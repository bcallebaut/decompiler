/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.belgiplast.quasar.assembly;

import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author T0194671
 */
public class ClassFile {
    private LowLevelClassFile backend;
    

    public ClassFile(InputStream is) throws IOException {
        backend = new LowLevelClassFile(is);
    }
    
    public ClassVersionEnum getVersion(){
        return ClassVersionEnum.version(backend.major, backend.minor);
    }
    
    public String getName(){
        return backend.cp.get(((StringRef)backend.cp.get(backend.thisclass)).getRef() - 1).toString().replaceAll("/",".");
    }
    
    public String getSuperName(){
        return  ((ClassInfo)backend.cp.get(backend.super_class - 1)).getName().replaceAll("/",".");
    }
    
    public void dump(){
        System.out.println("Version : " + getVersion().name());
        System.out.println("Name : " + getName());
        System.out.println("extends :  " + getSuperName());
        for (Integer i : backend.getInterfaces()){
            System.out.println("implements :  " + backend.cp.get(i - 1 ));
        }
        for (FieldInfo i : backend.getFields()){
            System.out.println("field :  " + i.getName() + " " + i.getDescriptor());
        }
        for (MethodInfo i : backend.getMethods()){
            System.out.println("method :  " + i.getName() + " " + i.getDescriptor());
            for (AttributeInfo nfo : i.getAttributes()){
                System.out.println("Name : " + nfo.getName());
                if (nfo.getName().equals("Code")){
                    nfo.getInfo();
                }
            }
        }
        
        
    }
}
