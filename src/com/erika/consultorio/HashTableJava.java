package com.erika.consultorio;

import javax.swing.*;
import java.util.HashMap;
import java.util.Scanner;

public class HashTableJava {
    HashMap<String, Patient> map = new HashMap<>();
    Trie trie = new Trie();
    BinarySearchTree tree = new BinarySearchTree();

    //Will ask for information
    //Create a new patient and fill with the information given
    public void Start(String register){
        System.out.println("ID|Nombre|Edad|FechaCita ");
        Patient patient1 = new Patient(register);
        //It first searches on trie to see if patient(student) has
        //already been registered
        if (trie.search(patient1.getStudentid())==true){
            //if true it means we will only be updating the hash table(map)
            System.out.println("El paciente ya nos ha visitado\nActualizar su informacion");
            JOptionPane.showMessageDialog(null,"El paciente ya nos habia visitado");
            //key = Studentid, element=patient
            map.put(patient1.getStudentid(), patient1);
        }else{
            //if false, it means we have a new patient
            //we insert it on trie,tree, and hash table(map)
            System.out.println("Paciente Nuevo");
            JOptionPane.showMessageDialog(null,"Paciente nuevo");
            trie.insert(patient1.getStudentid());//we´ll only store the id for trie and tree
            tree.insert(Integer.parseInt(patient1.getStudentid()));
            map.put(patient1.getStudentid(), patient1);

        }

    }

    //Search function works to show us the patient information
    public void Search(String id){
        //first we make sure it´s on trie
        //if true it means it will be on the hash table
        if (trie.search(id)==true){
            System.out.println("El paciente esta en el sistema");
            JOptionPane.showMessageDialog(null,"El paciente esta en el sistema");
            Patient patient1 = map.get(id);//we´ll need these to access the patient information and print it
            //if it´s true, it means the patient has an appointment schedule and shows the info
            if(map.containsKey(id)==true) {
                System.out.println("El paciente " + patient1.getName() + " con id: " + patient1.getStudentid() + " tiene " + patient1.getAge() +
                        " años y su cita es el " + patient1.getDate());
                JOptionPane.showMessageDialog(null,"El paciente " + patient1.getName() + " con id: " + patient1.getStudentid() + " tiene " + patient1.getAge() +
                        " años y su cita es el " + patient1.getDate());
            }else{
                //otherwise it means the patient has visited the doctor but has no future appointments
                JOptionPane.showMessageDialog(null,"El paciente no tiene cita proxima");
                System.out.println("El paciente no tiene cita proxima");
            }
        }else{
            //patient has not been registered
            JOptionPane.showMessageDialog(null,"El paciente no fue encontrado");
            System.out.println("El paciente no fue encontrado");
        }

    }

    //deletes a patient´s appointment but will still be registeres on the system
    //meaning it´s still on the trie
    //we´ll only dete it from map
    public void Erase(String del){
        if(map.containsKey(del)==true){
            map.remove(del);
            JOptionPane.showMessageDialog(null,"Cita fue borrada");
        }else {
            //patient was not found
            System.out.println("El paciente no fue encontrado");
            JOptionPane.showMessageDialog(null, "El paciente no fue encontrado");
        }

    }

    public void showStudents(){
        System.out.println("Estudiantes Registrados: ");
        tree.inorder();
        //JOptionPane.showMessageDialog(null, "Estudiantes registrados: "+ tree.inorder());


    }
}
