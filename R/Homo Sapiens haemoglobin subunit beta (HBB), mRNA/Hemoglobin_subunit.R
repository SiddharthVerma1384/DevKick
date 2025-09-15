# Install rentrez if not installed
if(!requireNamespace("rentrez", quietly = TRUE)){
  install.packages("rentrez")
}

# Load the package
library(rentrez)

# Example: Download DNA sequence from NCBI using accession number
accession <- "NM_000518"
#Homo Sapiens haemoglobin subunit beta (HBB), mRNA
#NCBI Reference Sequence: https://www.ncbi.nlm.nih.gov/nuccore/NM_000518

# Fetch the sequence in FASTA format
dna_sequence <- entrez_fetch(db = "nuccore", id = accession, rettype = "fasta")

# Print the sequence
cat(dna_sequence)

# Save the sequence into a file
write(dna_sequence, file = "dna_sequence.fasta")

cat("\nDNA sequence downloaded and saved as dna_sequence.fasta\n")