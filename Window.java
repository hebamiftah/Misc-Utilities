abstract class Window implements GUIComponent {
    private int width;
    private int height;
    private boolean minimized;
    private boolean visible;

    public Window(int width, int height){
        this.width = width;
        this.height = height;
        this.minimized = false;
        this.visible = false;
    }

    public boolean isMinimized() {
        return minimized;
    }

    public void displayNormal(){
        System.out.println(".........................");
        System.out.println(":a "+width+"x"+height+" minimal window:");
        System.out.println(".........................");
    }
    public void display(){
        if(!visible){
            System.out.println("(Nothing to see here)");
        }
        else{
            if(minimized){
                System.out.println("[a "+width+"x"+height+" minimal window (minimized)]");
            }
            else{
                displayNormal();
            }
        }
    }
    public void setVisible(boolean visible){
        this.visible = visible;
    }
    public boolean isVisible(){
        return visible;
    }
    public void resize(int width, int height){
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void minimize(){
        minimized = true;
    }
    public void restore(){
        minimized = false;

    }
}

