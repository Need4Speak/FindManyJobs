package interview.DesignPattern;

public class Decorator {
    public static void main(String[] args) {
        Hero victor = new Victor();
        GalacticWarriors galacticWarriors = new GalacticWarriors(victor);
        galacticWarriors.init();
    }
}

interface Hero {
    public void init();
}

class Victor implements Hero {
    @Override
    public void init() {
        System.out.println("维克托");
    }
}

abstract class HeroDecorator implements Hero {
    private Hero hero;

    public HeroDecorator(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void init() {
        hero.init();
    }
}

class GalacticWarriors extends HeroDecorator {
    private Hero hero;

    public GalacticWarriors(Hero hero) {
        super(hero);
    }

    @Override
    public void init() {
        super.init();
        setSkin();
    }

    private void setSkin() {
        System.out.println("银河战士皮肤衣");
    }
}
