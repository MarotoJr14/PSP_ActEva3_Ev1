class Pedido:
    def __init__(self, id_pedido, descripcion):
        self.id_pedido = id_pedido
        self.descripcion = descripcion

    def __str__(self):
        return f"Pedido {self.id_pedido}: {self.descripcion}"