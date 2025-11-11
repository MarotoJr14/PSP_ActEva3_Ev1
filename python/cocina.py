from cocinero import Cocinero
from pedido import Pedido
import threading
import random

def main():
    lock = threading.Lock()
    logFile = "log_pedidos.txt"
    open(logFile, "w").close()
    
    platos = ["Paella", "Tortilla de patatas", "Gazpacho", "Ensalada mixta",
            "Croquetas", "Pimientos de Padrón", "Bocadillo de jamón", "Pan con tomate", "Lentejas", "Arroz a la cubana",
            "Pollo al ajillo", "Sopa de ajo", "Calamares a la romana", "Merluza a la plancha", "Huevos rotos",
            "Patatas bravas", "Fabada asturiana", "Cocido madrileño", "Tostada con aceite y tomate", "Churros con chocolate"]
    
    numPedidos = random.randint(10, 20)
    pedidos = []
    for i in range(1, numPedidos + 1):
        pedidos.append(Pedido(i, random.choice(platos)))

    numCocineros = random.randint(3, 5)
    cocineros = []
    for i in range(1, numCocineros + 1):
        cocineros.append(Cocinero(f"Cocinero {i}", pedidos, lock, logFile))

    for c in cocineros:
        c.start()

    for c in cocineros:
        c.join()

    print("\nTodos los pedidos han sido procesados.")

if __name__ == "__main__":
    main()
