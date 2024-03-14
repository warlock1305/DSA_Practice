package week3;

import week3.labTask.FileUtils;
import week3.labTask.IPAddress;
import week3.labTask.IPSearch;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        IPAddress[] arr = FileUtils.readFile("C:/Users/User/IdeaProjects/DSA_Practice/assets/IP2LOCATION.csv");
        System.out.println(IPSearch.search(arr, "128.13.8.1").getEndIp());

		}
    }
