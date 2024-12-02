package br.edu.unisep.gerenciador.model;

import javax.swing.*;
import java.util.ArrayList;

public class GerenciadorDeTarefas {
    public static void main(String[] args) {
        ArrayList<String> tarefas = new ArrayList<>();
        int opcao;

        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(
                    "1. Adicionar tarefa\n2. Marcar tarefa como concluída\n3. Remover tarefa\n4. Exibir todas as tarefas\n5. Sair"));

            switch (opcao) {
                case 1 -> tarefas.add(JOptionPane.showInputDialog("Digite a nova tarefa:"));
                case 2 -> {
                    if (tarefas.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nenhuma tarefa para concluir.");
                    } else {
                        int index = Integer.parseInt(JOptionPane.showInputDialog("Tarefas:\n" + listar(tarefas) + "\nEscolha a tarefa a concluir:")) - 1;
                        tarefas.set(index, tarefas.get(index) + " (Concluída)");
                    }
                }
                case 3 -> {
                    if (tarefas.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Nenhuma tarefa para remover.");
                    } else {
                        int index = Integer.parseInt(JOptionPane.showInputDialog("Tarefas:\n" + listar(tarefas) + "\nEscolha a tarefa a remover:")) - 1;
                        tarefas.remove(index);
                    }
                }
                case 4 -> JOptionPane.showMessageDialog(null, "Tarefas:\n" + (tarefas.isEmpty() ? "Nenhuma tarefa cadastrada." : listar(tarefas)));
                case 5 -> JOptionPane.showMessageDialog(null, "Saindo...");
                default -> JOptionPane.showMessageDialog(null, "Opção inválida.");
            }
        } while (opcao != 5);
    }

    private static String listar(ArrayList<String> tarefas) {
        StringBuilder lista = new StringBuilder();
        for (int i = 0; i < tarefas.size(); i++) {
            lista.append(i + 1).append(". ").append(tarefas.get(i)).append("\n");
        }
        return lista.toString();
    }
}

