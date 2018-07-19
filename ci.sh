##################################################
### Tool   : aggs_v1.sh (19-05-2017)           ###
### aggs   : automate git github setup         ###
### target : to make package management system ###
##################################################





###############################
### Setting up a repository ###
###############################





############
# Step: 01 #
############

echo
echo 01. Done...Initializing who am I.
git config --global user.email "noormim2404@gmail.com"
git config --global user.name "kamrunNur"


############
# Step: 02 #
############
 
echo 02. Done...Initializing a new Git repo for this project.
echo
git init


############
# Step: 03 #
############

echo
echo 03. Done...Saving changes to the repository.
git add .


############
# Step: 04 #
############

echo 04. Done...Committing a modified version of a file to the repo.
echo

# 2018.July 19 
## ADDED feedback_system_skeleton.jpeg

git commit -m "ADDED feedback_system_skeleton.jpeg"


############
# Step: 05 #
############

# List your existing remotes in order to get the name of the remote you want to change.
echo
echo 05. Done...checking remote origin.
echo
git remote -v


############
# Step: 06 #
############

# Change your remote's URL from SSH to HTTPS with the git remote set-url command.
echo
echo 06. Done...Updating remote URL.
git remote set-url origin https://github.com/kamrunNur/CSE365-AI


############
# Step: 07 #
############

# Verify that the remote URL has changed.
echo 07. Done...Verifying remote URL.
echo
git remote -v


############
# Step: 08 #
############

echo
echo 08. Pushing local codebase to remote repo...Repo-to-repo collaboration: git push
echo
git push origin master
git push --all -f https://github.com/kamrunNur/CSE365-AI