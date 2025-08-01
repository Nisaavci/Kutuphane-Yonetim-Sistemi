import java.util.ArrayList;//ArrayList sınıfını içe aktarır.
import java.util.List;//list sınıfını içe aktarır
import java.util.Scanner;//Scanner sınıfını içe aktarır, kullanıcı girdilerini okumak için kullanılır.




public class Kutuphane {//Kütüphane sınıfı tanımlandı
    private List<Kitap> kitapListesi;
    //Kütüphanedeki kitap ve üyeleri tutmak için kullanılan List koleksiyonları.

    private List<Uye> uyeListesi;

    public Kutuphane() {//Kutuphane sınıfının yapıcısı, yeni bir Kutuphane nesnesi oluşturur.
        this.kitapListesi = new ArrayList<>();//kitapListesi değişkeni için yeni bir ArrayList oluşturur.
        this.uyeListesi = new ArrayList<>();//uyeListesi  değişkeni için yeni bir ArrayList oluşturur.
        varsayilanVerileriBaslat();//metot çağırma

    }

    private void varsayilanVerileriBaslat() {
        //Varsayılan kitap ve üye verilerini oluşturur ve bunları kitapListesi ve uyeListesine ekler.
        // En az 5 kitap tanımlı
        // "Küçük Prens" isimli, Antoine de Saint-Exupéry tarafından yazılmış ve "ISBN001" ISBN numarasına sahip
        // yeni bir Kitap nesnesi oluşturuluyor ve kitapListesi'ne ekleniyor.
        //diğer kitaplar içinde aynı şey geçerli
        kitapListesi.add(new Kitap("Küçük Prens", "Antoine de Saint-Exupéry", "ISBN001"));
        kitapListesi.add(new Kitap("Yabancı", "Albert Camus", "ISBN002"));
        kitapListesi.add(new Kitap("Dönüşüm", "Franz Kafka", "ISBN003"));
        kitapListesi.add(new Kitap("İçimizdeki Şeytan", "Sabahattin Ali", "ISBN004"));
        kitapListesi.add(new Kitap("Suç ve Ceza", "Fyodor Dostoyevski", "ISBN005"));

        // En az 5 üye tanımlı
        //üye ismi ve numarasını içeren  yeni bir Uye nesnesi oluşturulup,uyeListesi'ne ekleniyor.
        uyeListesi.add(new Uye("Ali AVCI", 101));
        uyeListesi.add(new Uye("Yavuz IŞIK", 102));
        uyeListesi.add(new Uye("Emre YILMAZ", 103));
        uyeListesi.add(new Uye("Ayşe ÖSTÜRK ", 104));
        uyeListesi.add(new Uye("Mehmet IŞIK", 105));
    }
    public void kitapEkle(Kitap kitap) {// // Metodun tanımı: Kitap nesnesini parametre olarak alır.
        kitapListesi.add(kitap);//kitabı listeye ekler
        System.out.println(kitap.getBaslik() + " kütüphaneye eklendi.");// kitabın kütüphanye eklendiğini ekrana yazar
    }

    public void kitapSil(String isbn) {//Belirtilen ISBN'e sahip kitabı arar ve bulursa listeden siler.
        Kitap kitap = kitapAra(isbn);//ısbn numarasına göre kitabı arar kitap değişkenine atar.
        if (kitap != null) {//eğer kitap mevcutsa
            kitapListesi.remove(kitap);//kitapListesinden kitabı çıkarır.
            System.out.println(kitap.getBaslik() + " kütüphaneden silindi.");//ekrana kitabın silindiğini yazar
        } else {//kitap yoksa
            System.out.println("Kitap bulunamadı.");//kitap bulunamadığını ekrana  yazar.
        }
    }

    public void uyeEkle(Uye uye) {//Yeni bir üye ekler ve eklenen üyenin ismini ekrana yazar.
        uyeListesi.add(uye);
        System.out.println(uye.getIsim() + " kütüphaneye üye olarak eklendi.");
    }

    public void uyeSil(int uyeNo) {//Belirtilen üye numarasına sahip üyeyi arar ve bulursa listeden siler.
        Uye uye = uyeAra(uyeNo);//üye numarasına göre üyeyi arar uye değişkenine atar
        if (uye != null) {// eğer üye mevcutsa
            uyeListesi.remove(uye);//üye silinir.uyeListesinden çıkarılır.
            System.out.println(uye.getIsim() + " kütüphaneden üye olarak silindi.");//ekrana üyenin silindiği yazar
        } else {//üye yoksa
            System.out.println("Üye bulunamadı.");//ekrana yazar
        }
    }

    public void kitaplariListele() {//Kütüphanedeki tüm kitapları listeler ve ekrana yazar.
        System.out.println("Kütüphanedeki Kitaplar:");
        for (Kitap kitap : kitapListesi) {//For-each döngüsü ile kitapListesi listesindeki her Kitap nesnesi kitap değişkenine atanır.
            System.out.println(kitap);//ve ekrana yazdırılır
        }
    }

    public void mevcutKitaplariListele() {//Kütüphanedeki mevcut kitapları listeler ve ekrana yazar.
        System.out.println("Mevcut Kitaplar:");
        for (Kitap kitap : kitapListesi) {// For-each döngüsü ile kitapListesi listesindeki her Kitap nesnesi kitap değişkenine atanır.
            if (kitap.isMevcut()) {//kitabın mevcut olup olmadığı kontrol edilir eğer mevcutsa kitap ekrana yazılır.
                System.out.println(kitap);
            }
        }
    }

    public void oduncAlinanKitaplariListele() {//Kütüphanede ödünç alınan kitapları listeler ve ekrana yazar.
        System.out.println("Ödünç Alınan Kitaplar:");
        for (Kitap kitap : kitapListesi) {// For-each döngüsü ile kitapListesi listesindeki her Kitap nesnesi kitap değişkenine atanır.
            if (!kitap.isMevcut()) {//eğer kitap mevcut değilse ödünç alınanlar listesinde ekrana yazılır.
                System.out.println(kitap);
            }
        }
    }

    public void uyeleriListele() {//Kütüphanedeki tüm üyeleri listeler ve ekrana yazar.
        System.out.println("Kütüphanedeki Üyeler:");
        for (Uye uye : uyeListesi) {// For-each döngüsü ile uyeListesi listesindeki her Uye  nesnesi uye  değişkenine atanır.
            System.out.println(uye);//ve ekrana yazılır
        }
    }

    public void uyeSorgula(int uyeNo) {
        //Üye numarasına göre üyeyi sorgular.


        Uye uye = uyeAra(uyeNo);//uyenumarasına göre üye aranır durumu(var mı yok mu ) uye değişkenine atanır
        if (uye != null) {// Eğer üye bulunursa
            System.out.println("Üye Bulundu: " + uye.getIsim());//üye ismiyle beraber ekrana yazılır
            List<Kitap> gecmis = uye.getOduncGecmisi();//Üyenin ödünç aldığı kitapların geçmişini tutan listeyi gecmis değişkenine atar.

            if (gecmis.isEmpty()) {//uye geçmişi boşsa(ödünç aldığı kitap yoksa ) ife girer
                System.out.println("Üyenin ödünç aldığı kitap yok.");//ekrana yazar
            } else {// geçmiş boş değilse
                System.out.println("Üyenin ödünç aldığı kitaplar:");
                for (Kitap kitap : gecmis) {//for-each döngüsüyle ödünç aldığı kitaplar listelenir.
                    System.out.println(kitap);
                }
            }
        } else {// Eğer üye bulunmazsa, "Üye bulunamadı" mesajını ekrana yazar.
            System.out.println("Üye bulunamadı.");
        }
    }

    public void kitapSorgula(String  ISBN) {
        Kitap kitap = kitapAra(ISBN);//ısbn göre kitap aranır durumu(var mı yok mu ) kitap değişkenine atanır
        if (kitap != null) {// Eğer kitap bulunursa
            System.out.println("Kitap Bulundu: " + kitap.getBaslik());//kitap ismiyle beraber ekrana yazılır
        } else {// Eğer kitap bulunmazsa, "Kitap bulunamadı" mesajını ekrana yazar.
            System.out.println("Kitap bulunamadı.");
        }
    }
    public Kitap kitapAra(String ISBN) {//ISBN numarasına göre kitabı arar ve bulursa döner, bulamazsa null döner.
        for (Kitap kitap : kitapListesi) {// For-each döngüsü ile kitapListesi listesindeki her Kitap  nesnesi kitap değişkenine atanır.
            if(kitap.getISBN().equals(ISBN)){// eğer girilen ısbn kitapListesindeki her hangi kitap ısbn si ile aynı ise
                return kitap;//kitabı döndürür
            }
        }
        return null;
    }

    public Uye uyeAra(int uyeNo) {//Üye numarasına göre üyeyi arar ve bulursa döner, bulamazsa null döner.
        for (Uye uye : uyeListesi) {// For-each döngüsü ile uyeListesi listesindeki her Uye   nesnesi uye değişkenine atanır.
            if (uye.getUyeNo() == uyeNo) {//eğer uye numarası ile girilen numara aynı ise
                return uye;//üye döner
            }
        }
        return null;
    }
    public void uyeBilgileriniGuncelle(int uyeNo, String yeniAd,int yeniNo) {
        //güncellenecek kişinin üye numarasına göre üyeyi arar ve günceller
        Uye uye = uyeAra(uyeNo);
        if (uye != null) {//uye varsa
            uye.setIsim(yeniAd);// girilen bilgileri üyenin güncel adı ve
            uye.setUyeNo(yeniNo);//güncel numarasını  olarak ayarlar

            System.out.println("Üye bilgileri güncellendi: " + yeniAd + " ");
        } else
        {
            System.out.println("Üye bulunamadı.");
        }
    }
    public void kitapOduncAl(String isbn, int uyeNo) {//kitap ödünç alma işlemini gerçekleştiren metot
        Kitap kitap = kitapAra(isbn);//ISBN numarasına göre kitabı arar
        Uye uye = uyeAra(uyeNo);//uye numarasıına göre üyeyi arar
        if (kitap != null && uye != null) {//eğer kitap ve üye mevcutsa ödünç alma işlemi gerçekleşir
            uye.kitapOduncAl(kitap);//üye kitabı ödünç alır
        } else {//eğer kitap ve üye bulunamazsa
            if (kitap == null) {//kitap yoksa
                System.out.println("Kitap bulunamadı.");//kitap bulunamadı mesajı ekrana ayzdırılır
            }
            if (uye == null) {//üye yoksa
                System.out.println("Üye bulunamadı.");//bu mesaj ekrana yazdırılır
            }
        }
    }

    public void kitapIadeEt(String isbn, int uyeNo) {//Kitap iaede işlemi gerçekleştiren metod
        Kitap kitap = kitapAra(isbn);//kitap ISBN nosuna göre kitap aranır  durumu kitap değişkenine atanır
        Uye uye = uyeAra(uyeNo);// üye nosuna göre üye aranır ve  durumu(yoksa null döner) uye değişkenine atanır
        if (kitap != null && uye != null) {//eğer kitap ve üye varsa iade işlemi gerçekleşir
            uye.kitapIadeEt(kitap);
        } else {//yoksa
            if (kitap == null) {//kitap yoksa
                System.out.println("Kitap bulunamadı.");//mesajını yazar
            }
            if (uye == null) {//üye yoksa
                System.out.println("Üye bulunamadı.");//mesajını  ekrana yazar
            }
        }
    }

    public static void main(String[] args) {//sistemin çalışacağı ana blok
        Kutuphane kutuphane = new Kutuphane();// yeni bir kütüphane nesnesi oluşturulur
        Scanner scanner = new Scanner(System.in);//kullanıcıdan giriş almayı sağlar yeni bir Scanner nesnesi oluşturur.
        int secim;//kullanıcı seçimlerini tutmak için secim değişkeni oluşturuldu
        System.out.println("   <<<  KÜTÜPHANE YÖNETİM SİSTEMİ  >>>");
        System.out.println("Merhaba Hoş Geldiniz:)");
        do {
            //Kullanıcının seçim yapmasını sağlayan bir döngü başlatır. Kullanıcı 0 girene kadar döngü devam eder.
            //Ekrana kullanıcıyı yönlendirecek ve değer almamızı sağlayacak bilgiler yazar


            System.out.println("lütfen yapmak istediğiniz işlem numarasını giriniz");
            System.out.println("1. Kitap Ekle");
            System.out.println("2. Üye Ekle");
            System.out.println("3. Kitapları Listele");
            System.out.println("4. Üyeleri Listele");
            System.out.println("5. Mevcut Kitapları Listele");
            System.out.println("6. Ödünç Alınan Kitapları Listele");
            System.out.println("7. Kitap Sil");
            System.out.println("8. Üye Sil");
            System.out.println("9. Kitap Ödünç Al");
            System.out.println("10.Kitap İade Et");
            System.out.println("11.Üye Sorgula");
            System.out.println("12 Kitap Sorgula");
            System.out.println("13 üye Bilgilerini Güncelle");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminiz: ");
            secim = scanner.nextInt();//kullanıcıdan aldığı seçim numarasını secim değişkenine atar.
            scanner.nextLine(); // Yeni satır karakterini tüketir boş string döndürmeyi önler.

            switch (secim) {//Kullanıcının seçim yapmasına göre farklı işlemleri gerçekleştiren bir switch ifadesi.
                case 1://kitap ekleme işlemi 1'e basılınca çalışır
                    System.out.print("Kitap ismi: ");
                    String kitapIsmi = scanner.nextLine();//kullanıcıdan kitap ismini alıyor ve kitapISmi değişkeninde tutuyoruz
                    System.out.print("Yazar: ");//aynı işlemi yazar ve ISBN nosu içinde yapıyoruz
                    String yazar = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    Kitap yeniKitap = new Kitap(kitapIsmi, yazar, isbn);//Kullanıcıdan alınan bilgilerle yeniKitap nesnesi oluşturur
                    kutuphane.kitapEkle(yeniKitap);//Oluşturulan yeniKİtap nesnesini kütüphanedeki kitaplar listesine  ekler.
                    break;//işlemi bitirir yapıdan çıkar
                case 2://üye ekleme işlemi case 0-11 e kadar seçilen numaraya göre o case işlemini yapar
                    System.out.print("Üye ismi: ");//kullanıcıyı yönlendirerek girdi alım işlemi devam eder .
                    String uyeIsmi = scanner.nextLine();
                    System.out.print("Üye No: ");
                    int uyeNo = scanner.nextInt();
                    scanner.nextLine(); // Yeni satır karakterini tüket
                    //nextInt() metodundan sonra gelen yeni satır karakterini tüketmek için kullanılır.
                    // Bu, sonraki nextLine() çağrılarının doğru çalışmasını sağlar.
                    Uye yeniUye = new Uye(uyeIsmi, uyeNo);//Kullanıcıdan alınan bilgilerle yeni bir Uye nesnesi oluşturur.
                    kutuphane.uyeEkle(yeniUye);//Oluşturulan Uye nesnesini kütüphaneye ekler.
                    break;
                case 3://kitapları listeleme işlemi
                    kutuphane.kitaplariListele();// Bu metot Kütüphanedeki tüm kitapları ekrana yazdırır
                    break;
                case 4://üyeleri listeleme işlemi
                    kutuphane.uyeleriListele();// Bu metot Kütüphanedeki tüm üyeleri ekrana yazdırır
                    break;
                case 5://mevcut kitapları listeleme işlemi
                    // aynı şekilde metotlar çağrıldıkça ekrana istenen ifade yazdırılır.
                    kutuphane.mevcutKitaplariListele();
                    break;
                case 6://ödünç alınan kitapları listeleme işlemi
                    kutuphane.oduncAlinanKitaplariListele();
                    break;
                case 7://kitap silme işlemi (kullanıcıdan silinecek kitabın ISBN numarasını alarak kütüphaneden silmeyi amaçlar).
                    System.out.print("Silinecek kitabın ISBN'si: ");
                    String silinecekIsbn = scanner.nextLine();//Scanner nesnesini kullanarak kullanıcının girdiği ISBN numarasını okur
                    // ve silinecekIsbn değişkenine atar.
                    kutuphane.kitapSil(silinecekIsbn);
                    //Bu metod, belirtilen ISBN numarasına göre kitabı arar ve bulursa kitapListesinden siler.
                    // Ayrıca, kitabın silindiğini veya bulunamadığını ekrana yazdırır.
                    break;
                case 8://üye silme işlemi(kullanıcıdan silinecek üyeniin numarasını alarak kütüphaneden silmeyi amaçlar.)

                    System.out.print("Silinecek üyenin No'su: ");
                    int silinecekUyeNo = scanner.nextInt();//Scanner nesnesini kullanarak kullanıcının girdiği üye numarasını okur
                    // ve silinecekUyeNo değişkenine atar.
                    scanner.nextLine(); // nextInt() metodundan sonra gelen yeni satır karakterini tüketmek için kullanılır.
                    // Bu, sonraki nextLine() çağrılarının doğru çalışmasını sağlar.
                    kutuphane.uyeSil(silinecekUyeNo);
                    //Bu metod, belirtilen üye numarasına göre üyeyi arar ve bulursa uyeListesinden siler.
                    // Ayrıca, üyenin silindiğini veya bulunamadığını ekrana yazdırır.
                    break;
                case 9://kitap ödünç alma işlemi
                    System.out.print("Ödünç alınacak kitabın ISBN'si: ");
                    String oduncIsbn = scanner.nextLine();
                    System.out.print("Üyenin No'su: ");
                    int oduncUyeNo = scanner.nextInt();
                    scanner.nextLine();
                    //Kullanıcının girdiği bir satırın tamamını okur.
                    // Yeni satır karakterine kadar olan tüm karakterleri okur ve geri döner.
                    kutuphane.kitapOduncAl(oduncIsbn, oduncUyeNo);//metoda ödünç alınacak kitap nosunu ve alan üye nosunu gönderir
                    break;
                case 10://kitap iade etme işlemi
                    System.out.print("İade edilecek kitabın ISBN'si: ");
                    String iadeIsbn = scanner.nextLine();
                    //Scanner nesnesini kullanarak kullanıcının girdiği ISBN numarasını okur ve iadeIsbn değişkenine atar.
                    System.out.print("Üyenin No'su: ");
                    int iadeUyeNo = scanner.nextInt();
                    //Scanner nesnesini kullanarak kullanıcının girdiği üye numarasını okur ve iadeUyeNo değişkenine atar.
                    scanner.nextLine(); // Yeni satır karakterini tüket
                    kutuphane.kitapIadeEt(iadeIsbn, iadeUyeNo);
                    //Bu metod, belirtilen ISBN numarasına göre kitabı ve üye numarasına göre üyeyi arar. Eğer her ikisi de bulunursa,
                    // üye kitabı iade eder.
                    // Eğer kitap veya üye bulunamazsa, uygun hata mesajları ekrana yazdırılır
                    break;
                case 11://üye sorgulama işlemi
                    System.out.print("Sorgulanacak üyenin No'su: ");
                    int sorguUyeNo = scanner.nextInt();//Scanner nesnesini kullanarak kullanıcının girdiği üye numarasını okur
                    // ve sorguUyeNo değişkenine atar.


                    scanner.nextLine(); // Yeni satır karakterini tüket
                    //nextInt() metodundan sonra gelen yeni satır karakterini tüketmek için kullanılır.
                    // Bu, sonraki nextLine() çağrılarının doğru çalışmasını sağlar.
                    kutuphane.uyeSorgula(sorguUyeNo);
                    /*Bu metod, belirtilen üye numarasına göre üyeyi arar ve bulursa üyenin ismini ve ödünç alma geçmişini ekrana yazar.
                    Eğer üyenin ödünç aldığı kitap yoksa, "Üyenin ödünç aldığı kitap yok" mesajını yazar.
                    Eğer üye bulunamazsa, "Üye bulunamadı" mesajını ekrana yazar.
                     */
                    break;
                 case 12://kitap sorgulama işlemi
                     System.out.print("Sorgulanacak Kitabın ISBN'si: ");
                 String sorguKitapISBN = scanner.nextLine();
                 kutuphane.kitapSorgula(sorguKitapISBN);
                 break;
                case 13://üye bilgilerini güncelleme işlemi
                    System.out.println("Bilgisi güncellenecek üye nosunu giriniz");
                    int sorguUyeNumarası = scanner.nextInt();
                    System.out.println("Güncel üye nosunu giriniz");
                    int güncelUyeNumarası = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Üyenin yeni güncel adını soyadını giriniz");
                   String güncelUyeIsmi= scanner.nextLine();
                    kutuphane.uyeBilgileriniGuncelle(sorguUyeNumarası,güncelUyeIsmi,güncelUyeNumarası);
                    break;
                case 0://çıkış yapar
                    System.out.println("Çıkış yapılıyor.");
                    break;
                default://geçersiz durum girme ihtimalinde hata mesajı
                    System.out.println("Geçersiz seçim! Tekrar deneyin.");
            }
        } while (secim != 0);//0 seçilene kadar döngü devam eder

    scanner.close();//Scanner nesnesini kapatır ve kullanmış olduğu kaynakları serbest bırakır.
    }
}

