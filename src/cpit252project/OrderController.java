
package cpit252project;

public class OrderController {
    Icommand command;

    public void setCommand(Icommand command) {
        this.command = command;
    }
    
    public void ConfirmbuttonPressed(){
        command.confirmOrder();
    }
    public void CanclebuttonPressed(){
        command.cancleOrder();
    }
}
