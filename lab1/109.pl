while (<>) {
    print if /(^\S*$)|(^[^\s].*[^\s]$)/ ;
}