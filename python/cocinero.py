import threading
import time
import random

class Cocinero(threading.Thread):
    def __init__(self, nombre, pedidos, lock, logFile):
        super().__init__()
        self.nombre = nombre
        self.pedidos = pedidos
        self.lock = lock
        self.logFile = logFile

    def run(self):
        while True:
            with self.lock:
                if not self.pedidos:
                    break
                pedido = self.pedidos.pop(0)
            
            self.preparar_pedido(pedido)

            with self.lock:
                self.registrar_log(pedido)

    def preparar_pedido(self, pedido):
        print(f"[{self.nombre}] recibe {pedido}")
        print(f"[{self.nombre}] está preparando {pedido}")
        time.sleep(random.uniform(1, 3))
        print(f"[{self.nombre}] ha terminado {pedido}")
    
    def registrar_log(self, pedido):
        with open(self.logFile, "a", encoding="utf-8") as f:
            f.write(f"[{self.nombre}] ha preparado {pedido}\n")
