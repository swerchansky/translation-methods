while (<>) {
    print if /(z|y|x).{5,17}(z|y|x)/ ;
}