public class ArbolColores{
    private NodoArbol raiz;

    /**
     * Constructor del arbol. Para efectos de la clase tablero, se agregan los colores a la lista, primero ordenados alfabeticamente, 
     * y luego con otro metodo se ordenan de acuerdo a la frecuencia de cada color.
     * @param colores la lista de colores ya inicializada en la clase tablero.
     */

    public ArbolColores(String[] colores){
        this.raiz = null;
        for(String color : colores){
            NodoArbol nuevo = new NodoArbol(color);
            raiz = agregar(raiz, nuevo);
        }
    }

    /**
     * Metodo recursivo para agregar los colores iniciales al arbol. Se ordenan de manera alfabetica inicialmente, y luego en otro metodo se actualiza el orden de los nodos
     * de acuerdo a la frecuencia de cada color.
     * @param nodo el nodo raiz actual del arbol, donde comienza la recursividad
     * @param nuevo el nuevo nodo que va a ser agregado
     * @return La nueva rama agregada
     */

    private NodoArbol agregar(NodoArbol nodo, NodoArbol nuevo){
        //Caso base: encuentra una referencia de un nod vacia:
        if(nodo == null){
            return nuevo;
        }

        //Caso recursivo: Ordenamos por frecuencia

        int frecNuevo = nuevo.getFrecuencia();
        int frecActual = nodo.getFrecuencia();

        if(frecNuevo < frecActual){
            nodo.setIzquierdo(agregar(nodo.getIzquierdo(), nuevo));
        }else if(frecNuevo > frecActual){
            nodo.setDerecho(agregar(nodo.getDerecho(), nuevo));
        }else{
            //Si las frecuencias son iguales: compara alfabeticamente los colores y llama al mismo metodo de acuerdo a la referencia de izquierda o derecha:
            String colorNuevo = nuevo.getColor();
            String colorActual = nodo.getColor();

            if(colorNuevo.compareTo(colorActual) <0){
                nodo.setIzquierdo(agregar(nodo.getIzquierdo(), nuevo));

            }else if(colorNuevo.compareTo(colorActual) > 0){
                nodo.setDerecho(agregar(nodo.getDerecho(), nuevo));
            }
        }
        
        //Actualizamos la altura, para que el arbol sea autobalanceado
        int alturaNuevoNodo = 0;

        if(nodo.getIzquierdo() != null){
            alturaNuevoNodo = nodo.getIzquierdo().getAltura();
        }
        if(nodo.getDerecho() != null){
            alturaNuevoNodo = Math.max(alturaNuevoNodo, nodo.getDerecho().getAltura());
        }
        nodo.setAltura(alturaNuevoNodo + 1);
        return nodo;
    }


    /**
     * Metodo para buscar un color en el arbol.
     * @param nodo el nodo actual en el que se busca recursivamente.
     * @param c el color por encontrar.
     * @return el nodo con el respectivo color.
     */
    private NodoArbol buscarColor(NodoArbol nodo, String c){

        if(nodo == null){
            return null;
        }

        if(nodo.getColor().equals(c)){
            return nodo;
        }
        NodoArbol izquierdo = buscarColor(nodo.getIzquierdo(), c);
        if(izquierdo != null){
            return izquierdo;
        }
        return buscarColor(nodo.getDerecho(), c);
    }

    /**
     * Metodo principal donde se actualiza la frecuencia de cada color/
     * @param color el color del nodo a incrementar
     * @param frec la frecuencia q vamos a aniadir al nodo
     */
    public void actualizarFrecuencia(String c, int frec){
        NodoArbol nodo = buscarColor(this.raiz, c);
        
        if(nodo!= null){
            nodo.setFrecuencia(nodo.getFrecuencia() + frec);
            this.raiz = eliminar(this.raiz, c);
            this.raiz = agregar(this.raiz, nodo);
        }
    }

    /**
     * Metodo recursivo para eliminar un nodo con un color. Esto se usa solo para efectos de actualizar la frecuencia de los colores.
     * @param nodo el nodo recursivo, se empieza desde la raiz.
     * @param c el color del nodo que se desea eliminar
     * @return la nueva raiz trass haber eliminado el color
     */
    private NodoArbol eliminar(NodoArbol nodo, String c){
        //Caso base, ya se termino de reordenar el nodo, o simplemente no se encontro.
        if(nodo == null){
            return null;
        }   

        //Encontramos el nodo que queremos eliminar
        if(c.equals(nodo.getColor())){

            //Caso 1: nodo sin hijos
            if(nodo.getIzquierdo() == null && nodo.getDerecho() == null){
                return null;
            }   
            //Caso 2: nodo con hijo derecho
            if(nodo.getIzquierdo() == null){
                return nodo.getDerecho();
            }
            //Caso 3: nodo con hijo izquierdo
            if(nodo.getDerecho() == null){
                return nodo.getIzquierdo();
            }
            //Caso 4: Nodo con hijos tanto izquierdo como derecho
            
            NodoArbol minimo = encontrarMinimo(nodo.getDerecho());

            nodo.setColor(minimo.getColor());
            nodo.setFrecuencia(minimo.getFrecuencia());

            nodo.setDerecho(eliminar(nodo.getDerecho(), minimo.getColor()));


        }else{ //No lo encontramos
            nodo.setIzquierdo(eliminar(nodo.getIzquierdo(), c));
            nodo.setDerecho(eliminar(nodo.getDerecho(), c));
        }

        //Actualizamos la altura, para que el arbol sea autobalanceado
        int alturaNuevoNodo = 0;

        if(nodo.getIzquierdo() != null){
            alturaNuevoNodo = nodo.getIzquierdo().getAltura();
        }
        if(nodo.getDerecho() != null){
            alturaNuevoNodo = Math.max(alturaNuevoNodo, nodo.getDerecho().getAltura());
        }
        nodo.setAltura(alturaNuevoNodo + 1);
        return nodo;
    }

    /**
     * Metodo recursivo para encontrar el color menos frecuente en un arbol. Solo se busca el nodo mas a la izquierda del arbol
     * @param nodo el nodo en donde se aplica la recursividad.
     */
    private NodoArbol encontrarMinimo(NodoArbol nodo){
        if(nodo == null){
            return null;
        }
        while(nodo.getIzquierdo() != null ){
            nodo = nodo.getIzquierdo();
        }
        return nodo;
    }
}







