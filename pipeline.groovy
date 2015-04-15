
index_DB = {
    transform( '.1.bt2', 
                '.2.bt2', 
                '.3.bt2', 
                '.4.bt2', 
                '.rev.1.bt2', 
                '.rev.2.bt2') {
    exec """
        bowtie2-build $input.fna $output1.prefix.prefix
    """
    }
}

map_reads = {
    transform("1.bt2","fastq.gz","fastq.gz") {
        exec """
            bowtie2 
            -1 $input1 -2 $input2 
            -x $input3 
            | samtools view -bSu - 
            | samtools sort - $output.prefix"
            bowtie2 
            -1 $input1 -2 $input2
            -x $input3 
        """
    }
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
    index_DB //+
//    "%_*.fastq.gz" * [ map_reads +
//    extract_reads +
//    assemble ]
}
