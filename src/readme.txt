
git status
git config
git log

git add "file name"

*** -m inline msg when commit
git commit -m "msg"

*** equals to "git branch branch-name --> git checkout branch-name"
git checkout -b branch-name

*** origin is the alias of remote repository's URL
git remote add origin https://

*** push master branch to remote repo,
*** -u: local branch pull from / push to remote without indication
git push -u origin master

*** push my-branch to remote repo
git push origin my-branch

pull request

*** pull master branch
git pull origin master

*** pull current branch
git pull

*** switch to master branch
git checkout master

*** skip adding to stage
git commit -a

*** showing remote
git remote -v

*** inspect one remote
git remote show origin

*** rename remote url
git remote rename oldname new namge

*** merge branch2 to branch1
git checkout branch1
git merge branch2
git push branch1