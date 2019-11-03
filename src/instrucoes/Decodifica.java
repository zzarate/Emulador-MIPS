package instrucoes;

import java.util.Arrays;
import java.util.Scanner;

import alu.OpALU;
import main.Memoria;
import registradores.HILO;
import registradores.OperacoesRegistradores;
public class Decodifica {

    private int rs = 0;
    private int rt = 0;
    private char[] valorImmI = new char [16];
    private char[] valorImmJ = new char [26];
	
    private InstrucoesR tipoR = new InstrucoesR();
    private OpALU alu = new OpALU();
    private HILO hilo = new HILO();

    public void separaInstrucao (String instrucao, int PC, OperacoesRegistradores opReg, Memoria memoria, Scanner sc){

        //Separa OpCode
        char opCode [];
        char vetInstrucao [];
        opCode = new char [6];
        vetInstrucao = new char [32];
        vetInstrucao = instrucao.toCharArray();
        
        for (int i = 0; i < 6; i++) {
            opCode [i] = vetInstrucao[i];
        }
        verificaInstrucao(opCode, vetInstrucao, PC, opReg, memoria, sc);
    }


    void verificaInstrucao (char [] opCode, char [] vetInstrucao, int PC, OperacoesRegistradores opReg, Memoria memoria, Scanner sc){
        OpCode instrucoes = new OpCode();

        //opCode tipo R
        if (Arrays.equals(opCode, instrucoes.R )) {
            tipoR.separaFunct(vetInstrucao, PC, opReg, alu, hilo, memoria, sc);
        }
        
        //opCode Add immediate
        if (Arrays.equals(opCode, instrucoes.addi )) {
            salvaTipoI(vetInstrucao);//Salva valor do imediato
            opReg.setValorReg(rt, alu.addi(opReg.getValorReg(rs), opReg.extendValor(valorImmI)), memoria);
        }
        
        //Add immediate unsigned
        if (Arrays.equals(opCode, instrucoes.addiu )) {
            salvaTipoI(vetInstrucao);//Salva valor do imediato
            opReg.setValorReg(rt, alu.addiu(opReg.getValorReg(rs), opReg.extendValor(valorImmI)), memoria);
        }

        //Load word
        if (Arrays.equals(opCode, instrucoes.lw )) {
            salvaTipoI(vetInstrucao);//Salva valor no imediato
            int enderecoMem = (int) Long.parseLong(new String(alu.addi(opReg.getValorReg(rs), opReg.extendValor(valorImmI))), 2); //Memória[C + s] | memoria [rs + imm]

            String palavra = null;
            String [] temp= new String [4];
		    temp[0] =Integer.toBinaryString((memoria.memory[enderecoMem] & 0xFF) + 0x100).substring(1);
		    temp[1]= Integer.toBinaryString((memoria.memory[enderecoMem+1] & 0xFF) + 0x100).substring(1);
		    temp[2]= Integer.toBinaryString((memoria.memory[enderecoMem+2] & 0xFF) + 0x100).substring(1);
		    temp[3]= Integer.toBinaryString((memoria.memory[enderecoMem+3] & 0xFF) + 0x100).substring(1);

		    palavra = temp [0] + temp [1] + temp [2] + temp [3];

            opReg.setValorReg(rt, palavra.toCharArray(), memoria);

        }

        //Load half word
        if (Arrays.equals(opCode, instrucoes.lh )) {
            salvaTipoI(vetInstrucao);//Salva valor no imediato
            int enderecoMem = Integer.parseInt(new String(alu.addi(opReg.getValorReg(rs), opReg.extendValor(valorImmI)))); //Memória[C + s] | memoria [rs + imm]
            
            String palavra = null;
            String [] temp= new String [2];
		    temp[0] =Integer.toBinaryString((memoria.memory[enderecoMem+2] & 0xFF) + 0x100).substring(1);
		    temp[1]= Integer.toBinaryString((memoria.memory[enderecoMem+3] & 0xFF) + 0x100).substring(1);

		    palavra = temp [0] + temp [1];

            opReg.setValorReg(rt, palavra.toCharArray(), memoria);

        }

        //Load byte
        if (Arrays.equals(opCode, instrucoes.lb )) {
            salvaTipoI(vetInstrucao);//Salva valor no imediato
            int enderecoMem = Integer.parseInt(new String(alu.addi(opReg.getValorReg(rs), opReg.extendValor(valorImmI))), 2); //Memória[C + s] | memoria [rs + imm]
            
            String palavra = null;

		    palavra = Integer.toBinaryString((memoria.memory[enderecoMem+3] & 0xFF) + 0x100).substring(1);

            opReg.setValorReg(rt, palavra.toCharArray(), memoria);
        }

        //Store word
        if (Arrays.equals(opCode, instrucoes.sw )) {
            salvaTipoI(vetInstrucao);//Salva valor no imediato
            int enderecoMem = Integer.parseInt(new String(alu.addi(opReg.getValorReg(rs), opReg.extendValor(valorImmI))), 2); //Memória[C + s] | memoria [rs + imm]
            char [] rtTemp = opReg.getValorReg(rt);

            char [] byteTemp = new char [8];
            for (int i=0, k=31; i < 4; i++) {
                for (int j=7 ; j >= 0 ; j--, k--) {
                    byteTemp[j] = rtTemp[k];
                }
            memoria.memory[enderecoMem+i]= (byte) Integer.parseInt(new String(byteTemp), 2);
            }
        }

        //Store half word
        if (Arrays.equals(opCode, instrucoes.sh )) {
            salvaTipoI(vetInstrucao);//Salva valor no imediato
            int enderecoMem = Integer.parseInt(new String(alu.addi(opReg.getValorReg(rs), opReg.extendValor(valorImmI)))); //Memória[C + s] | memoria [rs + imm]
            char [] rtTemp = opReg.getValorReg(rt);

            char [] byteTemp = new char [8];
            for (int i = 0, k=8; i < 2; i++) {
                for (int j = 8; j >= 0 ; j--, k--) {
                    byteTemp[j] = rtTemp[k];
                }
            memoria.memory[enderecoMem+i]= (byte) Integer.parseInt(new String(byteTemp), 2);
            }
        }

        //Store byte
        if (Arrays.equals(opCode, instrucoes.sb )) {
            salvaTipoI(vetInstrucao);//Salva valor no imediato
            int enderecoMem = Integer.parseInt(new String(alu.addi(opReg.getValorReg(rs), opReg.extendValor(valorImmI)))); //Memória[C + s] | memoria [rs + imm]
            char [] rtTemp = opReg.getValorReg(rt);

            char [] byteTemp = new char [8];
            for (int i = 0, k=8; i < 1; i++) {
                for (int j = 8; j >= 0 ; j--, k--) {
                    byteTemp[j] = rtTemp[k];
                }
            memoria.memory[enderecoMem+i]= (byte) Integer.parseInt(new String(byteTemp), 2);
            }
        }

        //Load upper immediate
        if (Arrays.equals(opCode, instrucoes.lui )) {
            salvaTipoI(vetInstrucao);//Salva valor no imediato
            opReg.setValorReg(rt, opReg.extendValor(valorImmI), memoria);
        }

        //Andi
        if (Arrays.equals(opCode, instrucoes.andi )) {
            salvaTipoI(vetInstrucao);//Salva valor no imediato
            opReg.setValorReg(rt, alu.andi(opReg.getValorReg(rs), opReg.extendValor(valorImmI)), memoria);
        }

        //Ori
        if (Arrays.equals(opCode, instrucoes.ori )) {
            salvaTipoI(vetInstrucao);//Salva valor no imediato
            opReg.setValorReg(rt, alu.ori(opReg.getValorReg(rs), opReg.extendValor(valorImmI)), memoria);
        }

        //Set on less than immediate
        if (Arrays.equals(opCode, instrucoes.slti )) {
            salvaTipoI(vetInstrucao);//Salva valor no imediato
            opReg.setValorReg(rt, alu.slti(opReg.getValorReg(rs), opReg.extendValor(valorImmI)), memoria);
        }

        //Branch on equal 
        if (Arrays.equals(opCode, instrucoes.beq )) {
            salvaTipoI(vetInstrucao);//Salva valor no imediato
            opReg.setValorReg(rt, alu.beq(opReg.getValorReg(rs), opReg.extendValor(valorImmI)), memoria);

        }

        //Branch on not equal
        if (Arrays.equals(opCode, instrucoes.bne )) {
            salvaTipoI(vetInstrucao);//Salva valor no imediato
            opReg.setValorReg(rt, alu.bne(opReg.getValorReg(rs), opReg.extendValor(valorImmI)), memoria);
        }
        
        //Jump
        if (Arrays.equals(opCode, instrucoes.j )) {
            salvaTipoJ(vetInstrucao);

            char [] auxPC = new char [32];
            char [] newPC = new char [32];

            salvaTipoJ(vetInstrucao);
            int temp = PC+4;
            String pctemp= Integer.toBinaryString(temp);
            auxPC = opReg.extendValor(pctemp.toCharArray());      //Atualiza o PC para a proxima instrução

            for (int i = 0; i < 3; i++) {       //Armazena os 4 bits mais significativos do PC
                newPC[i] = auxPC[i];
            }
            for (int i = 3, j=0 ; i < 29; i++, j++) {       //Rcebe os 26 bits do imediato
                newPC[i] = valorImmJ [j];
            }
            for (int i = 29; i < 32; i++) {     //Adiciona zero nos dois bits menos significativo
                newPC [i] = '0';
            }
            temp = (int)Long.parseLong(new String(newPC), 2);
            opReg.setPC(temp);   //Atualiza o Proximo valor do PC
        }
        
        //Jump and link
        if (Arrays.equals(opCode, instrucoes.jal )) {
            char [] auxPC = new char [32];
            char [] newPC = new char [32];

            salvaTipoJ(vetInstrucao);
            int temp = PC+4;
            String pctemp= Integer.toBinaryString(temp);
            auxPC = opReg.extendValor(pctemp.toCharArray());      //Atualiza o PC para a proxima instruç
            opReg.setValorReg(31, auxPC, memoria);       //Guarda o valor do proximo PC no $RA

            for (int i = 0; i < 3; i++) {       //Armazena os 4 bits mais significativos do PC
                newPC[i] = auxPC[i];
            }
            for (int i = 3, j=0 ; i < 29; i++, j++) {       //Receber os 26 bits do imediato em sequencia
                newPC[i] = valorImmJ [j];
            }
            for (int i = 29; i < 31; i++) {     //Adiciona zero nos dois bits menos significativos
                newPC [i] = 0;
            }

            opReg.setPC(Integer.parseInt(new String(newPC), 2));   //Atualiza o Proximo valor do PC
        }
    }

    void salvaTipoJ(char [] vetInstrucao){

        //Reg imm
        for (int i = 6, j =0; i < 32; i++, j++) {
            valorImmJ [j] = vetInstrucao [i];
        }
    }

    void salvaTipoI (char [] vetInstrucao){
        char[] regDest = new char [5];

        //Reg rs
        for (int i = 6, j =0; i < 11; i++, j++) {
            regDest [j] = vetInstrucao[i];
        }
        rs= Integer.parseInt(new String(regDest), 2);

        //Reg rt
        for (int i = 11, j =0; i < 16; i++, j++) {
            regDest [j] = vetInstrucao[i];
        }
        rt= Integer.parseInt(new String(regDest), 2);
        
        //Reg imm
        for (int i = 16, j =0; i < 32; i++, j++) {
            valorImmI [j] = vetInstrucao[i];
        }
    }

}