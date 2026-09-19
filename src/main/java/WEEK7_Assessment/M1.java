package WEEK7_Assessment;

class Character {
    private int health;
    final int max;

    Character(int max) {
        this.max = max;
        health = max;
    }

    void takeDamage(int amount) {
        health = health - amount;
        if (health < 0) {
            health = 0;
        }
    }

    void heal(int amount) {
        health = health + amount;
        if (health > max) {
            health = max;
        }
    }

    int getHealth() {
        return health;
    }
}

public class M1 {
    public static void main(String[] args) {
        Character c = new Character(100);
        c.takeDamage(30);
        System.out.println(c.getHealth());
        c.heal(50);
        System.out.println(c.getHealth());
        c.takeDamage(150);
        System.out.println(c.getHealth());
    }
}
