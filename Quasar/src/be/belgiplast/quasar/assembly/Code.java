/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.belgiplast.quasar.assembly;

import be.belgiplast.quasar.assembly.LowLevelClassFile.ConstantPool;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;


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
        int c = 0;
        while (c < dis.readInt()){
            switch(dis.readByte()){
                case 0 :
            }
            
        }
    }

    public ConstantPool getConstantPool() {
        return cp;
    }
}
