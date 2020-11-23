package game;

import javafx.scene.input.KeyCode;

public abstract class LevelGenerator extends World {
    private final Animal animal;
    private Digit digits;

    @Override
    public void act(long now) {

    }

    public LevelGenerator() {
        add(new Bg("frogger_bg.png"));

        for (int i = 0; i < 5; i++) {
            add(new End(10 + 128 * i, 92));
        }

        animal = new Animal();
        add(animal);
        setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ESCAPE) {
                Director.MainMenu();
            }
        });
    }

    public void setNumber(int n) {
        int shift = 0;
        do {
            int d = n / 10;
            int k = n - d * 10;
            n = d;
            add(new Digit(k, 540 - shift, 25));
            shift += 30;
        } while (n > 0);
    }

    public void start(){
        animal.init();
        if (animal.changeScore()) {
            setNumber(animal.getPoints());
        }
        super.start();
    }
}
