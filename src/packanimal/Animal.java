package packanimal;

class Animal {
    private String nome;
    private String classe;
    private String familia;
    private int idade;
    private boolean vivo;
    private int caloria;
    private int força;

    public Animal(String nome, String classe, String familia) {
        this.nome = nome;
        this.classe = classe;
        this.familia = familia;
        this.idade = 0;
        this.vivo = true;
        this.caloria = 10;
        this.força = 10;
    }

    public void comer() {
        if (vivo && caloria < 100) {
            caloria += 10;
            força -= 2;
            System.out.println("O animal comeu e agora sua força é " + força + " e suas calorias valem " + caloria + ".");
        } else if (!vivo) {
            System.out.println("O animal está morto e não pode comer.");
        } else {
            System.out.println("O animal já está cheio!");
        }
    }

    public void correr() {
        if (vivo && caloria > 0) {
            força -= 5;
            caloria -= 5;
            System.out.println("O animal está correndo! Agora sua força é de " + força + " e suas calorias valem " + caloria + ".");
            if (força <= 0) morrer();
        } else if (!vivo) {
            System.out.println("O animal está morto e não pode correr.");
        } else {
            System.out.println("O animal está exausto e não pode correr.");
        }
    }

    public void dormir() {
        if (vivo) {
            força += 10;
            caloria -= 2;
            System.out.println("O animal está dormindo agora! Sua força aumentou para " + força + " e suas calorias diminuíram para " + caloria + ".");
        } else {
            System.out.println("O animal está morto e não pode dormir.");
        }
    }

    public void morrer() {
        força = 0;
        vivo = false;
        System.out.println("O animal morreu!");
    }

    public boolean estaVivo() {
        return vivo;
    }

    public void exibirStatus() {
        System.out.println("O animal se chama " + nome + ", é da classe " + classe + " e da família " + familia +
                           ". O animal possui força " + força + ", calorias " + caloria + " e idade " + idade + ".");
    }
}
