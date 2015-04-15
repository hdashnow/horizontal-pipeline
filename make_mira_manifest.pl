#!/usr/bin/env perl
use warnings;
use strict;

my $usage = "make_mira_manifest.pl reads.fq outfile assembly_name\n";

#Writes a mira manifest file to outfile

my $readsfile = $ARGV[0];
my $outfile = $ARGV[1];
my $project_name = $ARGV[2];

unless( open OUT, ">$outfile"){die "Couldn't open $outfile for writing\n$!";}

print OUT "
# Manifest describing a denovo assembly with
# one library of paired reads

project = $project_name
job = genome,denovo,accurate
readgroup = DataIlluminaLib
data = $readsfile
technology = solexa\n";

print STDERR "Written mira manifest file for $project_name\n";
