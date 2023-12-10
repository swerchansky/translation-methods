$wasNotEmptyLine = 0;
$wasEmptyLine = 0;

while(<>) {
    $line = $_;
    
    $trimLine = $line =~ s/^(\s*)(.*?)(\s*)$/\2/gr;
    $singleSpaceLine = $trimLine =~ s/(\s+)(\S+)/ \2/gr;
    
    if ($singleSpaceLine =~ /^$/) {
        if ($wasNotEmptyLine) {
            $wasEmptyLine = 1;
        }
    } else {
        if ($wasNotEmptyLine) {
            print "\n";
        }
        if ($wasEmptyLine) {
            print "\n";
        }
        $wasEmptyLine = 0;
        $wasNotEmptyLine = 1;
        print "$singleSpaceLine";
    }
}