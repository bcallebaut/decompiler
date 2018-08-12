/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.belgiplast.quasar.assembly;

/**
 *
 * @author T0194671
 */
public class InvokeDynamic implements Resolvable{
    private int bootstrap;
    private int nameType;

    public int getBootstrap() {
        return bootstrap;
    }

    public void setBootstrap(int bootstrap) {
        this.bootstrap = bootstrap;
    }

    public int getNameType() {
        return nameType;
    }

    public void setNameType(int nameType) {
        this.nameType = nameType;
    }
    
    @Override
    public void resolve(Object context) {
        
    }
    
}
