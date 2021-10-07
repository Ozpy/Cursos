from tkinter import *
ventana = Tk()
ventana.title("practica1")
ventana.geometry("500x500")
nom = StringVar()
def saludo():
    """TODO: Docstring for saludo.

                    :arg1: TODO
                    :returns: TODO

                    """
    print("Hola", nom.get())


nombre = Label(ventana, text="Nombre").place(x=10, y=50)
cajaNombre = Entry(ventana, textvariable=nom).place(x=100, y=50)
guardar = Button(ventana, text="Guardar",command=saludo).place(x=150, y=250)

ventana.mainloop()
