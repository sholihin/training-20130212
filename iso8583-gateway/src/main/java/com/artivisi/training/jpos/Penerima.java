/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.jpos;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISORequestListener;
import org.jpos.iso.ISOServer;
import org.jpos.iso.ISOSource;
import org.jpos.iso.channel.ASCIIChannel;

/**
 *
 * @author endy
 */
public class Penerima {
    public static void main(String[] args) throws Exception {
        Integer port = 20000;
        
        ISOServer server = new ISOServer(port, new ASCIIChannel(new ArtivisiPackager()), null);
        server.addISORequestListener(new ISORequestListener() {

            public boolean process(ISOSource pengirim, ISOMsg request) {
                try {
                    ISOMsg reply = (ISOMsg) request.clone();
                    reply.setMTI("0210");
                    reply.set(39, "0000");
                    System.out.println("Request : "+new String(request.pack()));
                    System.out.println("Reply : "+new String(reply.pack()));
                    pengirim.send(reply);
                    return true;
                } catch (Exception ex) {
                    Logger.getLogger(Penerima.class.getName()).log(Level.SEVERE, null, ex);
                } 
                return false;
            }
        });
        
        new Thread(server).start();
        System.out.println("Server siap di port "+port);
        
    }
}
