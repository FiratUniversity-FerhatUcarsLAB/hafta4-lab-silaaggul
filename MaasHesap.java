Ad Soyad: Sıla Ağgül
Öğrenci No:250541020
Tarih:05.11.2025
Görev Adı:Maaş Hesaplama
  

import java.util.Scanner;

public class MaasHesap {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Sabit oranlar
        final double SGK_ORANI = 0.14;
        final double GELIR_VERGISI_ORANI = 0.15;
        final double DAMGA_VERGISI_ORANI = 0.00759;

        System.out.println("====================================");
        System.out.println("MAAS HESAPLAMA SISTEMI");
        System.out.println("====================================");

        // Kullanıcıdan bilgileri al
        System.out.print("Calisanin ad soyadini girin: ");
        String adSoyad = input.nextLine(); // nextLine kullanımı (önemli!)
        
        System.out.print("Aylik brut maasi girin (TL): ");
        double brutMaas = input.nextDouble();
        
        System.out.print("Haftalik calisma saati (sabit 40 varsayilabilir, sadece bilgi icin): ");
        int haftalikSaat = input.nextInt();
        
        System.out.print("Mesai saati sayisini girin: ");
        int mesaiSaati = input.nextInt();

        // === Hesaplamalar ===
        double mesaiUcreti = (brutMaas / 160) * mesaiSaati * 1.5;
        double toplamGelir = brutMaas + mesaiUcreti;

        double sgkKesinti = toplamGelir * SGK_ORANI;
        double gelirVergisi = toplamGelir * GELIR_VERGISI_ORANI;
        double damgaVergisi = toplamGelir * DAMGA_VERGISI_ORANI;
        double toplamKesinti = sgkKesinti + gelirVergisi + damgaVergisi;

        double netMaas = toplamGelir - toplamKesinti;

        // İstatistikler
        double kesintiOrani = (toplamKesinti / toplamGelir) * 100;
        double saatlikNetKazanc = netMaas / 176.0;
        double gunlukNetKazanc = netMaas / 22.0;

        // === Çıktı ===
        System.out.println("\n====================================");
        System.out.println("MAAS BORDROSU");
        System.out.println("====================================");
        System.out.printf("Calisan: %s%n", adSoyad);

        System.out.println("\nGELIRLER:");
        System.out.printf("Brut Maas               : %.2f TL%n", brutMaas);
        System.out.printf("Mesai Ucreti (%d saat)    : %.2f TL%n", mesaiSaati, mesaiUcreti);
        System.out.println("------------------------");
        System.out.printf("TOPLAM GELIR            : %.2f TL%n", toplamGelir);

        System.out.println("\nKESINTILER:");
        System.out.printf("SGK Kesintisi (%.1f%%)      : %.2f TL%n", SGK_ORANI * 100, sgkKesinti);
        System.out.printf("Gelir Vergisi (%.1f%%)     : %.2f TL%n", GELIR_VERGISI_ORANI * 100, gelirVergisi);
        System.out.printf("Damga Vergisi (%.1f%%)     : %.2f TL%n", DAMGA_VERGISI_ORANI * 100, damgaVergisi);
        System.out.println("------------------------");
        System.out.printf("TOPLAM KESINTI          : %.2f TL%n", toplamKesinti);

        System.out.printf("\nNET MAAS                : %.2f TL%n", netMaas);
        System.out.println("====================================");

        // Ek istatistikler
        System.out.printf("Kesinti Orani           : %.1f%%%n", kesintiOrani);
        System.out.printf("Saatlik Net Kazanc      : %.2f TL%n", saatlikNetKazanc);
        System.out.printf("Gunluk Net Kazanc       : %.2f TL%n", gunlukNetKazanc);
        System.out.println("====================================");

        input.close();
    }
}

