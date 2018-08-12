/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.belgiplast.quasar.assembly;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author T0194671
 */
public class LowLevelClassFile {
    byte[] magic = new byte[] {(byte)0xca,(byte)0xfe,(byte)0xbe,(byte)0xbe};
    int major;
    int minor;
    ConstantPool cp;
    int accessFlags;
    int thisclass;
    int super_class;
    private ArrayList<Integer> interfaces = new ArrayList<>();
    private ArrayList<FieldInfo> fields = new ArrayList<>();
    private ArrayList<MethodInfo> methods = new ArrayList<>();
    private ArrayList<AttributeInfo> attributes = new ArrayList<>();

    public LowLevelClassFile(InputStream is) throws IOException{
        DataInputStream dis = new DataInputStream(is);
       int mag = dis.readInt();
       if (mag != 0xCAFEBABE)
           throw new IOException("Bad magic");
        minor = dis.readUnsignedShort();
        major = dis.readUnsignedShort();
        cp = new ConstantPool(dis);
        accessFlags = dis.readUnsignedShort();
        thisclass = dis.readUnsignedShort();
        super_class = dis.readUnsignedShort();
        for (int i = 0; i < dis.readUnsignedShort(); i++){
            interfaces.add(dis.readUnsignedShort());
        }
        for (int i = 0; i < dis.readUnsignedShort(); i++){
            fields.add(new FieldInfo(cp,dis));
        }
        int cnt = dis.readUnsignedShort();
        for (int i = 0; i < cnt; i++){
            methods.add(new MethodInfo(cp,dis));
        }
        cnt = dis.readUnsignedShort();
        for (int i = 0; i < cnt; i++){
            attributes.add(new AttributeInfo(cp,dis));
        }
    }
    
    public static class ConstantPool{
        private int size = 0;
        private java.util.ArrayList pool = new ArrayList();
        
        public ConstantPool(DataInputStream dis) throws IOException {
            size = dis.readUnsignedShort();
            size--;
            for (int i = 0; i < size; i++){
                byte tag = dis.readByte();
                switch (tag){
                    case 1: //UTF8 
                        pool.add(new StringValue(this,dis));
                        break;
                    case 3://Integer  
                        pool.add(new IntValue(this,dis));
                        break;
                    case 4://Float
                        pool.add(new FloatValue(this,dis));
                        break;
                    case 5://Long
                        pool.add(new LongValue(this,dis));
                        break;
                    case 6://Double          
                        pool.add(new DoubleValue(this,dis));
                        break;    
                    case 7://Class
                        ClassInfo ci = new ClassInfo(this,dis);
                        
                        pool.add(ci);
                        break;    
                    case 8://String
                        StringRef reference = new StringRef(this,dis);
                        pool.add(reference);
                        break;     
                    case 9://FieldRef
                        AbstractReference ref = new FieldRef(this,dis);
                        pool.add(ref);
                        break;      
                    case 10://MethodRef
                        ref = new MethodRef(this,dis);
                        pool.add(ref);
                        break;      
                    case 11://InterfaceMehodRef
                        ref = new InterfaceMethodRef(this,dis);
                        pool.add(ref);
                        break;      
                    case 12://NameAndType
                        NameAndTypeReference ntr = new NameAndTypeReference(this,dis);
                        pool.add(ntr);
                        break;      
                    case 15://MethodHandle         
                        MethodHandle mh = new MethodHandle();
                        mh.setKind(dis.readByte());
                        mh.setReference(dis.readUnsignedShort());
                        pool.add(mh);
                        break;      
                    case 16://MethodType
                        MethodType mt = new MethodType();
                        mt.setReference(dis.readUnsignedShort());
                        pool.add(mt);
                        break;      
                    case 18://InvokeDynamic
                        InvokeDynamic id = new InvokeDynamic();
                        id.setBootstrap(dis.readUnsignedShort());
                        id.setNameType(dis.readUnsignedShort());
                        pool.add(id);
                        break;      
                    default:
                }
            }
        }

        public int size() {
            return pool.size();
        }

        public <T> T get(int index) {
            return (T)pool.get(index);
        }
        
        public void replace(Object src,Object target){
            int ndx = pool.indexOf(src);
            if (ndx > -1)
                pool.set(ndx, target);
        }

        public Iterator iterator() {
            return pool.iterator();
        }
        
        public void dump(){
            
        }
    }

    public ArrayList<Integer> getInterfaces() {
        return interfaces;
    }

    public ArrayList<FieldInfo> getFields() {
        return fields;
    }

    public ArrayList<MethodInfo> getMethods() {
        return methods;
    }

    public int getAccessFlags() {
        return accessFlags;
    }

    public ArrayList<AttributeInfo> getAttributes() {
        return attributes;
    }
    
    
    
    public void dump(){
        System.out.println("Magic : 0xCAFEBABE");
        System.out.println(String.format("Version : %d.%d",major,minor));
        cp.dump();
        System.out.println(String.format("AccessFlags : %x",accessFlags));
    }
}
