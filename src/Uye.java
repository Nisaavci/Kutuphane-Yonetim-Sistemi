import java.util.ArrayList;
//ArrayList ve List sınıflarını içe aktarır. Bu sınıflar, üyenin ödünç aldığı kitapları ve ödünç alma geçmişini tutmak için kullanılacak.
import java.util.List;

public class Uye {//uye sınıfı oluşturuldu
    //private anahtar kelimesi, değişkenin yalnızca tanımlandığı sınıf içinde erişilebilir olduğunu belirtir. Dışarıdan erişime kapalıdır.
    //uye bilgilerini tutan değişkenler tanımlanıyor
    private String isim;//uye ismini alacak değişken  tanımlandı
    private int uyeNo;//uye nosunu alacak değişken  tanımlandı
    //Üyenin ödünç aldığı kitapların listesini ve ödünç alma geçmişini tutan liste değişkenleri.
    private List<Kitap> oduncAlinanKitaplar;//ödünç aldığı kitaplar lsitesi ve
    private List<Kitap> oduncGecmisi; // Üyenin ödünç aldığı kitapların geçmişini tutacak Kitap nesnelerinden oluşan
    // bir liste tanımlanıyor.


    public Uye(String isim, int uyeNo) {//Uye sınıfının yapıcısı, yeni bir üye oluştururken çağrılır.
        this.isim = isim;//uyenin adını başlatır
        this.uyeNo = uyeNo;//uyenin numarasını başlatır
        this.oduncAlinanKitaplar = new ArrayList<>();//Ödünç alınan kitapların listesini boş bir ArrayList olarak başlatır.
        this.oduncGecmisi = new ArrayList<>(); // Ödünç alınan kitapların geçmişini boş bir ArrayList olarak başlatır.
    }

    public String getIsim() {//Üyenin ismini döndüren bir metot.
        return isim;
    }

    public void setIsim(String isim) {//Üyenin ismini ayarlayan bir metot.
        this.isim = isim;
    }

    public int getUyeNo() {//Üyenin numarasını döndüren bir metot.
        return uyeNo;
    }

    public void setUyeNo(int uyeNo) {//Üyenin numarasını ayarlayan bir metot.
        this.uyeNo = uyeNo;
    }

    public List<Kitap> getOduncAlinanKitaplar() {//Üyenin ödünç aldığı kitapların listesini döndüren bir metot.
        return oduncAlinanKitaplar;
    }

    public List<Kitap> getOduncGecmisi() {//Üyenin ödünç alma geçmişini döndüren bir metot.
        return oduncGecmisi;
    }

    public void kitapOduncAl(Kitap kitap) {//Üyenin bir kitabı ödünç almasını sağlayan metot.
        if (kitap.isMevcut()) {//Kitap mevcutsa (ödünç alınmamışsa).
            kitap.oduncAl(isim);//Kitabı ödünç alır ve ödünç alan kişinin ismini belirler.
            oduncAlinanKitaplar.add(kitap);//Kitabı ödünç alınan kitaplar listesine ekler.
            oduncGecmisi.add(kitap); // Kitabı ödünç alma geçmişine ekler.
        } else {//Eğer kitap ödünç alınmışsa.
            System.out.println(kitap.getBaslik() + " ödünç alınamaz.");//Kitabın ödünç alınamayacağını belirten mesajı ekrana yazar.
        }
    }

    public void kitapIadeEt(Kitap kitap) {//Üyenin bir kitabı iade etmesini sağlayan metot.
        if (oduncAlinanKitaplar.remove(kitap)) {//Kitabı ödünç alınan kitaplar listesinden kaldırır.
            kitap.iadeEt();//Kitabı iade eder.
        } else {//Eğer kitap bu üye tarafından ödünç alınmamışsa.
            System.out.println(kitap.getBaslik() + " bu üye tarafından ödünç alınmamış.");
            //Kitabın bu üye tarafından ödünç alınmadığını belirten mesajı ekrana yazar
        }
    }

    @Override//Bu metot Object sınıfının toString metodunu geçersiz kılar.
    public String toString() {//Üye nesnesinin string temsili olarak döndürülen bir metot.
        return "İsim: " + isim + ", Üye No: " + uyeNo + ", Ödünç Alınan Kitaplar: " + oduncAlinanKitaplar;
    }//Üyenin ismini, üye numarasını ve ödünç alınan kitapların listesini içeren bir string döner.
}
