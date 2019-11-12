# Emulador-MIPS
Emulador funcional com conjunto reduzido de instruções MIPS.
Functional emulator with reduced set of MIPS instructions. All the code and comments are in Portuguese.

## Como executar
### How to execute

Utilize o script "create_jar.sh" para compilar e gerar o executavel .jar.

No console digite "java -jar" seguido do nome do arquivo (Ex.: emulador.jar), em seguida o nome do arquivo binário da seção de texto do seu programa e do arquivo da seção de dados, nessa ordem respectivamente. Caso inverta a ordem seu programa não será executado.

Ex. de comando: `java -jar emulador.jar text.bin data.bin`

No final da execução do programa, será impresso na tela, os valores dos registradores e de todas as posições na memoria.

É necesário Java 11 ou superior.


## Instruções implementadas
### Implemented instructions

- Add
- Addi
- Addiu   (não testado/not tested)
- Sub
- Mult
- Div
- LW  (não testado/not tested)
- LH  (não testado/not tested)
- LB  (não testado/not tested)
- SW  (não testado/not tested)
- SH  (não testado/not tested)
- LB  (não testado/not tested)
- Lui  (não testado/not tested)
- Mfhi
- Mflo
- And
- Andi  (não testado/not tested)
- Or
- Ori
- Slt  (não testado/not tested)
- Slti  (não testado/not tested)
- Sll
- Srl
- Sra  (não testado/not tested)
- Beq
- Bne
- Jump
- Jr  (não testado/not tested)
- Jal  (não testado/not tested)

### Syscall
#### Funções implementadas
##### Implemented functions


- Print integer
- Print String
- Read integer
- Exit*
- Print char  (não testado/not tested)
- Read char  (não testado/not tested)
- Print integer in hex  (não testado/not tested)
- Print integer in binary  (não testado/not tested)
- Print integer as unsigned  (não testado/not tested)

\* Antes de encerrar a execução, imprime os valores contidos nos registradores e em todas as posições da memoria, em hex. Before ending the execution, print the values contained in the registers and in all memory positions, in hex.