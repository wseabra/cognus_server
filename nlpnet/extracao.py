import nlpnet
import sys
import random

nlpnet.set_data_dir('pos-pt/')

t = nlpnet.POSTagger()
tagged_text = t.tag(sys.argv[1])
lista_palavras = tagged_text[0]

#print lista_palavras

topico = ''
i = 0

while(i < len(lista_palavras)):
    tupla = lista_palavras[i]
    if tupla[1] == 'NPROP':
        topico += tupla[0]
        i = i+1
        if (i < len(lista_palavras)):
            proxTupla = lista_palavras[i]
            while(proxTupla[1] == 'NPROP'):
                topico += (' ' + proxTupla[0])
                i = i+1
                proxTupla = lista_palavras[i]
            topico += ';'
    i = i+1

if (len(topico) == 0):

    for (x,y) in lista_palavras:
        if (y == 'N'):
            topico += x + ";"


print topico
