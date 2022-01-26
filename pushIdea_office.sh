#！/bin/sh
read -p "输入要上传的文件,如果是全部请直接回车:" file_name
read -p "更新描述:" description
#echo "welcome $file_name"
if [ ${file_name} =='' ] ; then 
   file_name="*"
fi 
echo "welcome $file_name"
echo "第一步：查看当前的git仓库状态，可以使用git status"
git status
echo "第二步：更新全部"
git add ${file_name}
echo "第三步：接着输入git commit -m "$description""
git commit -m "${description}"
echo "第四步：先git pull,拉取当前分支最新代码"
git config --global pull.rebase true
git pull 
echo "第五步：push到远程master分支上"
git push -u  origin_new master
echo "如有问题，请查看.git 目录下的config文件"
