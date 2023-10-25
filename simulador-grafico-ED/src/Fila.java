
public class Fila {
    int fila[] = new int[10];
    int tamanho;
    int frente;
    int fim;

    public void enQueue(int data) {
        if(!isFull()){
            fila[fim] = data;
            fim = (fim+1)%10;
            tamanho++;
        }else{
            System.out.println("Fila cheia!");
        }
    }

    public int deQueue(){
        int data = fila[frente];

        if(!isEmpty()){
            frente = (frente+1)%10;
            tamanho--;
        }else{
            System.out.println("Fila vazia!");
        }
        
        return data;
    }

    public void show(){
        System.out.println("Elementos: ");
        for(int i=0;i<tamanho;i++){
            System.out.print(fila[(frente + i)%10] + " ");
        }

        System.out.println();

        for(int n : fila){
            System.out.print(n + " ");
        }
    }

    public int peek(){
        System.out.println(fila[frente]);
        return fila[frente];
    }

    public int getTamanho(){
        return tamanho;
    }

    public boolean isEmpty(){
        
        if(getTamanho() == 0){
            return true;
        }else{
            return false;
        }

    }

    public boolean isFull(){
        if(getTamanho() == 10){
            return true;
        }else{
            return false;
        }
    }

    public int getFim(){
        return fim;
    }

    public int getFrente(){
        return frente;
    }

    //Esse metodo existe pra realizar a organização da fila na hora de exibir
    //evitando que tenham espaços vazios no inicio da representação gráfica da fila
    public int getElement(int pos){
        return fila[pos];
    }
}
