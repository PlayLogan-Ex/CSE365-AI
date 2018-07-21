#!/usr/bin/env bash

: "
#   Git updater for Linux
#   Modified by: Nazmul Hossain (fb.com/nazmul.XI)
"

echo
echo "[*] Done...Initializing who am I."
git config user.email "rytotul@gmail.com"
git config user.name "Totul"

# Check whether it is already a git repo or not
if [[ -e ".git" ]]; then
    echo "[*] Already a git repo..."
else
    echo "[*] Done...Initializing a new Git repo for this project."
    echo
    git init
fi

echo
echo "[*] Done...Saving changes to the repository."
git add .

# Commit Changes
echo "[*] Done...Committing a modified version of a file to the repo."
echo
read -p "[*] Add commit message: " message
git commit -am "$message"

# List your existing remotes in order to get the name of the remote you want to change.
echo
echo "[*] Done...checking remote origin."
repo=$(git remote -v)

if [[ $1 == "u" ]]; then
    # Changes the remote's URL.
    echo
    read -p "The new repo URL: " n_repo
    echo
    echo "[*] Done...Updating remote URL."
    git remote set-url origin $n_repo

    # Verify that the remote URL has changed.
    echo "[*] Done...Verifying remote URL."
    repo2=$(git remote -v)
    if [[ $repo == $repo2 ]]; then
        echo "[*] Repo's are same..."
    else
        echo "[*] Repo Updated!"
    fi
fi

# Push the local changes to remote
echo
echo "[*] Pushing local codebase to remote repo...Repo-to-repo collaboration."
#git push origin master
git push --all -f git@github.com:PlayLogan-Ex/bookbucket.git