
index_DB = {
    exec """
        bowtie2-build $input.fasta $output.fasta.prefix
    """
}

map_reads = {
    transform("1.ebwt","fastq.gz","fastq.gz") {
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
    index_DB +
    "%_*.fastq.gz" * [ map_reads +
    extract_reads +
    assemble ]
}
