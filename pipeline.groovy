
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
	samtools view -u -f 4 -F 264 $input.prefix > tmps1.bam 
	| samtools view -u -f 8 -F 260 $input.prefix > tmps2.bam
	| samtools view -b -F 4 $input.prefix > tmps3.bam
	| samtools merge -u $output.bam tmps1.bam tmps2.bam tmps3.bam	
    """
}

bam_to_fastq = {
   exec """
	BamToFastq -bam $input.bam -fq1 $output_1.fq -fq2 $output_2.fq
   """

make_manifest ={
  exec "./make_mira_manifest.pl $input.fq ${input.fq.prefix}.manifest $input.fq.prefix",local
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
