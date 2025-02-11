
# Lab解析

## Part A
`git pull skeleton master`

这个时候我们会得到一堆冲突。我们进入lab1/Collatz.java解决冲突，留下有Bug的初始版本。

但是还有一些别的项目我们不想要被修改掉，怎么办呢？我们用git checkout把他们恢复成原样。--ours就是指的本地状态，--theirs就是指的远程状态。

```bash
git checkout --ours proj0/.
git checkout --ours lab2/.
git checkout  --ours lab3/.
```
到这里冲突解决已经完成了。接下来追踪所有这些改变，然后提交掉，就merge成功了。


```bash
git add proj0/. lab2/ lab3/.
git commit
git push
```
IYI: 所谓的解决冲突的过程，实际上是用`git add`选择最终状态的文件实现的，只要有冲突的文件尚未被git add，冲突解决就尚未完成。如果你 git add 了一个未真正解决冲突的文件，Git 仍然会接受它，最终结果会包含 ======= 和 >>>>>>> 这些冲突标记。

## Part B

对于撤销更改，有一个很实用的指令，`git revert`，在后面加上commit的ID，就会提交一个专门用于撤销的`commit`。我们再`git push`就行了。

# 一些千奇百怪的问题

## unrelated histories

有一些朋友设置CS61B的作业仓库时，是直接下载再git init的，这会导致`git pull skeleton master`时，没有任何相关历史：

```
From https://github.com/Berkeley-CS61B/skeleton-sp21
 * branch            master     -> FETCH_HEAD
fatal: refusing to merge unrelated histories
```

解决方案：在`git pull skeleton master`后面加上 `--allow-unrelated-histories`参数。

## 重新设置library-sp21

有些人的报错和library-sp21有关，往往是它的library-sp21也是直接下载了拖进来的，然后git add .又导致了一些问题。要修正这个问题我们需要

```
git submodules add https://github.com/Berkeley-CS61B/library-sp21 library-sp21/
git add .gitmodules
git commit
```
## rebase or merge
```
From https://github.com/Berkeley-CS61B/skeleton-sp21
 * branch            master     -> FETCH_HEAD
hint: You have divergent branches and need to specify how to reconcile them.
hint: You can do so by running one of the following commands sometime before
hint: your next pull:
hint:
hint:   git config pull.rebase false  # merge
hint:   git config pull.rebase true   # rebase
hint:   git config pull.ff only       # fast-forward only
hint:
hint: You can replace "git config" with "git config --global" to set a default
hint: preference for all repositories. You can also pass --rebase, --no-rebase,
hint: or --ff-only on the command line to override the configured default per
hint: invocation.
```
如果你遇到了这样的错误，我建议你跟着提示来设置git config为merge，merge是大多数情况下的默认选择，特别是对于经验尚且的你。
