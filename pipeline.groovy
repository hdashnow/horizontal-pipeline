
index_DB = {
    branch.DBname = output1.prefix.prefix
    transform( '.1.bt2', 
                '.2.bt2', 
                '.3.bt2', 
                '.4.bt2', 
                '.rev.1.bt2', 
                '.rev.2.bt2') {
    exec """
        bowtie2-build $input.fna $DBname
    """
    }
    forward(input, output1)
}

map_reads = {
//    transform("fastq","fastq",".1.bt2") {
        exec """
            bowtie2 
            -1 $input1 -2 $input2
            -x $DBname
            | samtools view -bSu - 
            | samtools sort - $output.prefix"
        """
//    }
}

extract_reads = {
    exec """
    """
}

assemble = {
    exec """
    """
}

run {
    index_DB +
    "%_*.fastq" * [ map_reads // +
//    extract_reads +
//    assemble 
]
}
