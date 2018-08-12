/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.belgiplast.quasar.assembly;

import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import be.belgiplast.quasar.assembly.LowLevelClassFile.ConstantPool;
import be.belgiplast.quasar.assembly.instructions.*;

/**
 *
 * @author T0194671
 */
public class Code {
    private ConstantPool cp;
    private int maxStack;
    private int maxLocals;
    private ArrayList<Instruction> instructions = new ArrayList<>();
    private ArrayList<ExceptionBlock> exceptions = new ArrayList<>();
    private ArrayList<AttributeInfo> attributes = new ArrayList<>();

    public Code(ConstantPool cp, byte[] data) throws IOException {
        this.cp = cp;
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
        maxStack = dis.readUnsignedShort();
        maxLocals = dis.readUnsignedShort();
        InstructionCounter c = new InstructionCounter(dis);
        int codeCount = dis.readInt();
        try{
        while (c.getCounter() < codeCount){
            Instruction ins = new Nop(c);
            int opcode = ((int)c.readByte() & 0x0000000FF);
            switch(opcode){
                //Constants
                case 0 : break;
                case 1 : ins = new AConstNull(c);break;
                case 2 : ins = new IConstm1(c);break;
                case 3 : ins = new Iconst0(c);break;
                case 4 : ins = new Iconst1(c);break;
                case 5 : ins = new Iconst2(c);break;
                case 6 : ins = new Iconst3(c);break;
                case 7 : ins = new Iconst4(c);break;
                case 8 : ins = new Iconst5(c);break;
                case 9 : ins = new Lconst0(c);break;
                case 10 : ins = new Lconst1(c);break;
                case 11 : ins = new Fconst0(c);break;
                case 12 : ins = new Fconst1(c);break;
                case 13 : ins = new Fconst2(c);break;
                case 14 : ins = new Dconst0(c);break;
                case 15 : ins = new Dconst1(c);break;
                case 16 : ins = new Bipush(c);break;
                case 17 : ins = new Sipush(c);break;
                case 18 : ins = new Ldc(c);break;
                case 19 : ins = new LdcW(c);break;
                case 20 : ins = new LdcW2(c);break;
                //Load
                case 21 : ins = new ILoad(c);break;
                case 22 : ins = new LLoad(c);break;
                case 23 : ins = new FLoad(c);break;
                case 24 : ins = new DLoad(c);break;
                case 25 : ins = new ALoad(c);break;
                case 26 : ins = new ILoad0(c);break;
                case 27 : ins = new ILoad1(c);break;
                case 28 : ins = new ILoad2(c);break;
                case 29 : ins = new ILoad3(c);break;
                case 30 : ins = new LLoad0(c);break;
                case 31 : ins = new LLoad1(c);break;
                case 32 : ins = new LLoad2(c);break;
                case 33 : ins = new LLoad3(c);break;
                case 34 : ins = new FLoad0(c);break;
                case 35 : ins = new FLoad1(c);break;
                case 36 : ins = new FLoad2(c);break;
                case 37 : ins = new FLoad3(c);break;
                case 38 : ins = new DLoad0(c);break;
                case 39 : ins = new DLoad1(c);break;
                case 40 : ins = new DLoad2(c);break;
                case 41 : ins = new DLoad3(c);break;
                case 42 : ins = new ALoad0(c);break;
                case 43 : ins = new ALoad1(c);break;
                case 44 : ins = new ALoad2(c);break;
                case 45 : ins = new ALoad3(c);break;
                case 46 : ins = new IALoad(c);break;
                case 47 : ins = new LALoad(c);break;
                case 48 : ins = new FALoad(c);break;
                case 49 : ins = new DALoad(c);break;
                case 50 : ins = new AALoad(c);break;
                case 51 : ins = new BALoad(c);break;
                case 52 : ins = new CALoad(c);break;
                case 53 : ins = new SALoad(c);break;
                //Stores
                case 54 : ins = new IStore(c);break;
                case 55 : ins = new LStore(c);break;
                case 56 : ins = new FStore(c);break;
                case 57 : ins = new DStore(c);break;
                case 58 : ins = new AStore(c);break;
                case 59 : ins = new IStore0(c);break;
                case 60 : ins = new IStore1(c);break;
                case 61 : ins = new IStore2(c);break;
                case 62 : ins = new IStore3(c);break;
                case 63 : ins = new LStore0(c);break;
                case 64 : ins = new LStore1(c);break;
                case 65 : ins = new LStore2(c);break;
                case 66 : ins = new LStore3(c);break;
                case 67 : ins = new FStore0(c);break;
                case 68 : ins = new FStore1(c);break;
                case 69 : ins = new FStore2(c);break;
                case 70 : ins = new FStore3(c);break;
                case 71 : ins = new LStore0(c);break;
                case 72 : ins = new LStore1(c);break;
                case 73 : ins = new LStore2(c);break;
                case 74 : ins = new LStore3(c);break;
                case 75 : ins = new AStore0(c);break;
                case 76 : ins = new AStore1(c);break;
                case 77 : ins = new AStore2(c);break;
                case 78 : ins = new AStore3(c);break;
                case 79 : ins = new IAStore(c);break;
                case 80 : ins = new LAStore(c);break;
                case 81 : ins = new FAStore(c);break;
                case 82 : ins = new DAStore(c);break;
                case 83 : ins = new AAStore(c);break;
                case 84 : ins = new BAStore(c);break;
                case 85 : ins = new CAStore(c);break;
                case 86 : ins = new SAStore(c);break;
                //Stack
                case 87 : ins = new Pop(c);break;
                case 88 : ins = new Pop2(c);break;
                case 89 : ins = new Dup(c);break;
                case 90 : ins = new DupX1(c);break;
                case 91 : ins = new Dupx2(c);break;
                case 92 : ins = new Dup2(c);break;
                case 93 : ins = new Dup2x1(c);break;
                case 94 : ins = new Dup2x2(c);break;
                case 95 : ins = new Swap(c);break;
                //Math
                case 96 : ins = new IAdd(c);break;
                case 97 : ins = new LAdd(c);break;
                case 98 : ins = new FAdd(c);break;
                case 99 : ins = new DAdd(c);break;
                case 100 : ins = new ISub(c);break;
                case 101 : ins = new LSub(c);break;
                case 102 : ins = new FSub(c);break;
                case 103 : ins = new DSub(c);break;
                case 104 : ins = new IMul(c);break;
                case 105 : ins = new LMul(c);break;
                case 106 : ins = new FMul(c);break;
                case 107 : ins = new DMul(c);break;
                case 108 : ins = new IDiv(c);break;
                case 109 : ins = new LDiv(c);break;
                case 110 : ins = new FDiv(c);break;
                case 111 : ins = new DDiv(c);break;
                case 112 : ins = new IRem(c);break;
                case 113 : ins = new LRem(c);break;
                case 114 : ins = new FRem(c);break;
                case 115 : ins = new DRem(c);break;
                case 116 : ins = new INeg(c);break;
                case 117 : ins = new LNeg(c);break;
                case 118 : ins = new FNeg(c);break;
                case 119 : ins = new DNeg(c);break;
                case 120 : ins = new IShl(c);break;
                case 121 : ins = new LShl(c);break;
                case 122 : ins = new IShr(c);break;
                case 123 : ins = new LShr(c);break;
                case 124 : ins = new IUShr(c);break;
                case 125 : ins = new LUShr(c);break;
                case 126 : ins = new IAnd(c);break;
                case 127 : ins = new LAnd(c);break;
                case 128 : ins = new IOr(c);break;
                case 129 : ins = new LOr(c);break;
                case 130 : ins = new IXor(c);break;
                case 131 : ins = new LXor(c);break;
                case 132 : ins = new IInc(c);break;
                //Conversions
                case 133 : ins = new I2L(c);break;
                case 134 : ins = new I2F(c);break;
                case 135 : ins = new I2D(c);break;
                case 136 : ins = new L2I(c);break;
                case 137 : ins = new L2F(c);break;
                case 138 : ins = new L2D(c);break;
                case 139 : ins = new F2I(c);break;
                case 140 : ins = new F2L(c);break;
                case 141 : ins = new F2D(c);break;
                case 142 : ins = new D2I(c);break;
                case 143 : ins = new D2L(c);break;
                case 144 : ins = new D2F(c);break;
                case 145 : ins = new I2B(c);break;
                case 146 : ins = new I2C(c);break;
                case 147 : ins = new I2S(c);break;
                //Comparisons
                case 148 : ins = new Lcmp(c);break;
                case 149 : ins = new Fcmpl(c);break;
                case 150 : ins = new Fcmpg(c);break;
                case 151 : ins = new Dcmpl(c);break;
                case 152 : ins = new Dcmpg(c);break;
                case 153 : ins = new Ifeq(c);break;
                case 154 : ins = new Ifne(c);break;
                case 155 : ins = new Iflt(c);break;
                case 156 : ins = new Ifge(c);break;
                case 157 : ins = new Ifgt(c);break;
                case 158 : ins = new Ifle(c);break;
                case 159 : ins = new Ificmpeq(c);break;
                case 160 : ins = new Ificmpne(c);break;
                case 161 : ins = new Ificmplt(c);break;
                case 162 : ins = new Ificmpge(c);break;
                case 163 : ins = new Ificmpgt(c);break;
                case 164 : ins = new Ificmple(c);break;
                case 165 : ins = new Ifacmpeq(c);break;
                case 166 : ins = new Ifacmpne(c);break;
                //Control
                case 167 : ins = new Goto(c);break;
                case 168 : ins = new Jsr(c);break;
                case 169 : ins = new Ret(c);break;
                case 170 : ins = new TableSwitch(c);break;
                case 171 : ins = new LookupSwitch(c);break;
                case 172 : ins = new IReturn(c);break;
                case 173 : ins = new LReturn(c);break;
                case 174 : ins = new FReturn(c);break;
                case 175 : ins = new DReturn(c);break;
                case 176 : ins = new AReturn(c);break;
                case 177 : ins = new Return(c);break;
                //References
                case 178 : ins = new GetStatic(c);break;
                case 179 : ins = new PutStatic(c);break;
                case 180 : ins = new GetField(c);break;
                case 181 : ins = new PutField(c);break;
                case 182 : ins = new InvokeVirtual(c);break;
                case 183 : ins = new InvokeSpecial(c);break;
                case 184 : ins = new InvokeStatic(c);break;
                case 185 : ins = new InvokeInterface(c);break;
                case 186 : ins = new be.belgiplast.quasar.assembly.instructions.InvokeDynamic(c);break;
                case 187 : ins = new New(c);break;
                case 188 : ins = new NewArray(c);break;
                case 189 : ins = new ANewArray(c);break;
                case 190 : ins = new ArrayLength(c);break;
                case 191 : ins = new AThrow(c);break;
                case 192 : ins = new CheckCast(c);break;
                case 193 : ins = new Instanceof(c);break;
                case 194 : ins = new MonitorEnter(c);break;
                case 195 : ins = new MonitorExit(c);break;
                //Extended
                case 196 : ins = new Wide(c);break;
                case 197 : ins = new MultiANewArray(c);break;
                case 198 : ins = new IfNull(c);break;
                case 199 : ins = new IfNonNull(c);break;
                case 200 : ins = new GotoW(c);break;
                case 201 : ins = new JsrW(c);break;
                //default
                default:
            }
         
            instructions.add(ins);
        }
        }catch (IOException ioe){}
    }

    public ConstantPool getConstantPool() {
        return cp;
    }

    public int getMaxStack() {
        return maxStack;
    }

    public int getMaxLocals() {
        return maxLocals;
    }

    public ArrayList<Instruction> getInstructions() {
        return instructions;
    }

    public ArrayList<ExceptionBlock> getExceptions() {
        return exceptions;
    }

    public ArrayList<AttributeInfo> getAttributes() {
        return attributes;
    }
    
    
    
    public void dump(){
        System.out.println(String.format("Max Stack %d",maxStack));
        System.out.println(String.format("Max Locals %d",maxLocals));
        for (Instruction ins : instructions){
            ins.dump();
        }
    }
    
    public static class InstructionCounter implements DataInput{
    
        private DataInput backend;
        private int counter = 0;

        public InstructionCounter(DataInput backend) {
            this.backend = backend;
        }
        
        @Override
        public void readFully(byte[] b) throws IOException {
            backend.readFully(b);
            counter+= b.length;
        }

        @Override
        public void readFully(byte[] b, int off, int len) throws IOException {
            backend.readFully(b, off, len);
            counter+= len;
        }

        @Override
        public int skipBytes(int n) throws IOException {
            counter+= n;
            return backend.skipBytes(n);
        }

        @Override
        public boolean readBoolean() throws IOException {
            counter++;
            return backend.readBoolean();
        }

        @Override
        public byte readByte() throws IOException {
            counter++;
            return backend.readByte();
        }

        @Override
        public int readUnsignedByte() throws IOException {
            counter++;
            return backend.readUnsignedByte();
        }

        @Override
        public short readShort() throws IOException {
            counter+=2;
            return backend.readShort();
        }

        @Override
        public int readUnsignedShort() throws IOException {
            counter+=2;
            return backend.readUnsignedShort();
        }

        @Override
        public char readChar() throws IOException {
            counter++;
            return backend.readChar();
        }

        @Override
        public int readInt() throws IOException {
            counter+=4;
            return backend.readInt();
        }

        @Override
        public long readLong() throws IOException {
            counter+=8;
            return backend.readLong();
        }

        @Override
        public float readFloat() throws IOException {
            counter+=4;
            return backend.readFloat();
        }

        @Override
        public double readDouble() throws IOException {
            counter+=8;
            return backend.readDouble();
        }

        @Override
        public String readLine() throws IOException {
            String result = backend.readLine();
            counter+= result.length();
            return result;
        }

        @Override
        public String readUTF() throws IOException {
            String result = backend.readUTF();
            counter+= result.length();
            return result;
        }

        public int getCounter() {
            return counter;
        }
    }
}
