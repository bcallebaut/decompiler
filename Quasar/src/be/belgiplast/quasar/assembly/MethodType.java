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
public class MethodType implements Resolvable{
    private int reference;

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }
    
    @Override
    public void resolve(Object context) {
        
    }
    
}
