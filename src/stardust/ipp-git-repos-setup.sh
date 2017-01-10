#!/bin/bash
usage()
{
  cat << EOF
  usage: $0 OPTIONS

  This script clones all Stardust and IPP related repositories into a given location

  OPTIONS:
    -h Show this message
    -l target location where the repositories should be cloned;
       if it is not set then the current working directory is used
    -u user/committer id for the Eclipse repositories which should be used if the ssh protocol is used
    -p Protocol which should be used for the Eclipse repositories to push the changes. 
       Valid options are https which is the default if nothing is specified or ssh. 
       If the protocol is set to ssh then the -u parameter must point to a valid committer Id
    -s Stash user id which should be used
EOF
}

_pushProtocol=https
_eclipseGitUser=
_stashGitUser=
# Use current working dir as the default checkout folder for the Stardust Git repositories
_targetDir=$(pwd)

while getopts "hl:u:p:s:" OPT
do
  case $OPT in
    h)
       usage
       exit 1
       ;;
    l)
       _targetDir=$OPTARG
       if [ ! -d $_targetDir ]; then
         echo target location does not exists
         exit 1
       fi
       ;;
    u)
       _eclipseGitUser=$OPTARG
       ;;
    s)
       _stashGitUser=$OPTARG
       ;;
    p)
       if [ "$OPTARG" != "ssh" -a "$OPTARG" != "https" ]; then
          echo "Unknown protocol. Only ssh and https are currently supported"
          exit 1
       fi
       _pushProtocol=$OPTARG
       ;;
    ?)
       usage
       exit
       ;;
  esac
done

if [ -z "$_stashGitUser" ]
then   
   echo "A valid committer Id for Stash is required. Please use the -s parameter."
   usage
   exit 1
fi

_stardustRemoteName=eclipse
_stashRemoteName=stash
_stardustGitBaseURL=http://git.eclipse.org/gitroot/stardust
_stardustGitPushURL=https://git.eclipse.org/r/p/stardust
_stashGitBaseURL=https://$_stashGitUser@services.sungard.com/git/scm/ipp

if [ -n $_eclipseGitUser ]
then
  if [ "$_pushProtocol" == "ssh" ]
  then
     _stardustGitPushURL=ssh://$_eclipseGitUser@git.eclipse.org:29418/stardust
  fi
fi

git_clone () {
  pushd . > /dev/null
  _gitproject=$1
  _qualified_gitproject=org.eclipse.stardust.$_gitproject

  if [ "$_gitproject" == "org.eclipse.stardust" ]
  then
    _qualified_gitproject=$_gitproject
  fi

  cd $_targetDir
  echo ---- $(pwd)
  git clone -o $_stardustRemoteName -b development $_stardustGitBaseURL/$_qualified_gitproject.git stardust/$_gitproject
  cd stardust/$_gitproject
  git remote set-url --push $_stardustRemoteName $_stardustGitPushURL/$_qualified_gitproject.git
  git remote add $_stashRemoteName $_stashGitBaseURL/$_qualified_gitproject
  git fetch $_stardustRemoteName
  git fetch $_stashRemoteName

  if [ "$_gitproject" == "product" ]; then
     git checkout -b development-IPP $_stashRemoteName/development-IPP
  fi
  popd > /dev/null
}

if [ ! -d $_targetDir/build.tools ]; then
  git_clone build.tools
fi
git_clone components
git_clone deploy.jee
git_clone documentation
git_clone engine
git_clone examples
git_clone ide
git_clone ide.simulation
git_clone ide.wst
git_clone org.eclipse.stardust
git_clone product
git_clone reporting.app.web
git_clone reporting.rt
git_clone reporting.ui
git_clone repository
git_clone ui.common
git_clone ui.web

git clone -o $_stashRemoteName -b master $_stashGitBaseURL/sungard sungard
