import controller.Controller;
import model.Model;
import view.View;

public class Runner {

    private Runner() {

    }

    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        View view = new View(controller);
        model.start();
    }
}
