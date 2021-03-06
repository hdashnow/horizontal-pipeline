
// Split reference multifasta into individual fasta files
split_DB = {
    transform('.fa') {
        output.dir="individual_fasta"
        exec """
          cd $dir && /vlsci/VR0002/shared/hdashnow/bin/split_fasta.pl ../$input.fna && cd .. 
        """
    }
}

// takes reference fasta file and pair of reads
// creates output in a folder
// 
iterative_assembler = {
    output.dir = branch.name
    exec """
        /vlsci/VR0002/shared/hdashnow/bin/iterative_assembler/iterative_assembler.py 
        -c /vlsci/VR0002/shared/hdashnow/bin/iterative_assembler/velvet.config 
        -t ../IS.fna 
        -o all_IS_EC958
        -i 10 
        -1 /vlsci/VR0002/shared/hdashnow/simulations/EC958_paired_sim_fir.fastq 
        -2 /vlsci/VR0002/shared/hdashnow/simulations/EC958_paired_sim_sec.fastq
    """
}

run {
//    split_DB +
//    "%.fa" * [ 
        iterative_assembler
//    ]
}
