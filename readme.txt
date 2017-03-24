1.github 创建新仓

本地版本库：

创建 文件夹 git

cd git

通过git init命令把这个目录变成Git可以管理的仓库

git init

本地版本库创建完成


 
github 版本库创建 

1。…or create a new repository on the command line

echo "# learn" >> README.md
git init
git add README.md
git commit -m "first commit"
git remote add origin https://github.com/evoleht/learn.git
git push -u origin master



2。…or push an existing repository from the command line

git remote add origin https://github.com/evoleht/learn.git
git push -u origin master


3。…or import code from another repository

You can initialize this repository with code from a Subversion, Mercurial, or TFS project.



常用命令：

add告诉Git，把文件添加到仓库

把最新内容推送到github
git push origin master

取回远程主机某个分支的更新

git pull origin master