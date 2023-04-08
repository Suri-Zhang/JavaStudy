package day25Oct6th;

/**
 * @author Rex Joush
 * @time 2022.10.06
 */
public class Frog extends Animal implements Swimmer {
    private float weight;
    public Frog(int weight) {
        this.weight = weight;
    }

    @Override
    float getWeight() {
        return weight;
    }

    @Override
    public void swim() {
        System.out.println("Frog is swimming");
    }

    public static void listTigers(Animal[] zoo) {
        // 1.遍历列表
        // 2.查找所有的 Tiger
        // 3.打印 tiger
        for (Animal animal : zoo) {
            if (animal instanceof Tiger) {
                Tiger tiger = (Tiger) animal;
                System.out.println(tiger.name);
            }
        }
    }

    public static void showHeaviest(Animal[] zoo) {
        // 1.遍历列表
        // 2.查找最重的
        // 3.打印最重的
        Animal maxAnimal = zoo[0];
        for (int i = 1; i < zoo.length; i++) {
            if (zoo[i].getWeight() > maxAnimal.getWeight()) {
                maxAnimal = zoo[i];
            }
        }
        System.out.println(maxAnimal);
    }
}

class Tiger extends Animal {
    public String name;
    public Tiger(String name) {
        this.name = name;
    }

    @Override
    float getWeight() {
        return 200;
    }
}

abstract class Animal {
    abstract float getWeight();
}

interface Swimmer {
    void swim();
}