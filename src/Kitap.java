import java.time.LocalDate;//LocalDate sınıfını içe aktarır. Bu sınıf, tarihleri temsil etmek için kullanılır.

public class Kitap {//Kitap sınıfını tanımlıyorum
    private String isim;//Değişkenlerimi tanımlıyorum:Kİtap ismi
    private String yazar;//Kİtap yazarı
    private String ISBN;//Kitap ISBN numarası
    private boolean mevcut; // Kitabın mevcut olup olmadığını gösteren bir değişken
    private String oduncAlan; // Kitabı ödünç alan kişinin adı
    private LocalDate oduncAlmaTarihi; // Ödünç alınan tarih
    private LocalDate teslimTarihi; // Teslim edilmesi gereken tarih
    private LocalDate iadeTarihi; // Kitabın iade edildiği tarih

    public Kitap(String isim, String yazar, String ISBN) {//Kitap sınıfının yapıcısı (constructor).
        // Yeni bir kitap oluştururken çağrılır ve kitap bilgilerini başlatır.
        this.isim = isim;//Kitap ismini atar.
        this.yazar = yazar;//Kitap yazarını atar.
        this.ISBN = ISBN;//Kitap ISBN nosunu atar
        this.mevcut = true; // Varsayılan olarak kitap mevcut
        this.oduncAlan = null; // Başlangıçta ödünç alan yok
        this.oduncAlmaTarihi = null; // Başlangıçta ödünç alma tarihi yok
        this.teslimTarihi = null; // Başlangıçta teslim tarihi yok
        this.iadeTarihi = null; // Başlangıçta iade tarihi yok
    }

    public String getISBN() {//Kitabın ISBN numarasını döndüren bir metot.
        return ISBN;
    }

    public String getBaslik() {//Kitabın başlığını (ismini) döndüren bir metot.
        return isim;
    }

    public boolean isMevcut() {//Kitabın kütüphanede  mevcut olup olmadığını döndüren bir metot
        return mevcut;
    }

    public String getOduncAlan() {//Kitabı ödünç alan kişinin adını döndüren bir metot.
        return oduncAlan;
    }

    public LocalDate getOduncAlmaTarihi() {//Kitabın ödünç alınma tarihini döndüren bir metot.
        return oduncAlmaTarihi;
    }

    public LocalDate getTeslimTarihi() {//itabın teslim edilmesi gereken tarihini döndüren bir metot.
        // en geç  ödünç alınma tarihinden 14 gün sonrası olarak belirlendi
        return teslimTarihi;
    }

    public LocalDate getIadeTarihi() {//Kitabın iade edilme tarihini döndüren bir metot.

        return iadeTarihi;
    }

    public void oduncAl(String uyeAdi) {//Kİtabın ödünç alınmasını sağlayan bir metod
        if (mevcut) {//Eğer kitap mevcutsa if bloğuna girer
            mevcut = false;//mevcut durumu false çevirir.mevcut kitapları sorgulattığımızda ödünç alınan kitabın listelenmemesi için
            oduncAlan = uyeAdi;//Kitabı ödünç alan kişiyi belirtir
            oduncAlmaTarihi = LocalDate.now();//Ödünç alma tarihini bugünün tarihi olarak ayarlar.
            teslimTarihi = oduncAlmaTarihi.plusDays(14); // Teslim tarihi 14 gün sonrası
            System.out.println(isim + " " + uyeAdi + " tarafından ödünç alındı.");//ödünç alma işlemini ekrana yazdırır.
        } else {
            System.out.println(isim + " zaten ödünç alınmış.");//kitap mevcut durumu başlangıçta alse ise blok çalışır .
            // kitabın olmadığı belirtilir.
        }
    }

    public void iadeEt() {//Kitabın iade edilmesini sağlayan bir metot
        if (!mevcut) {//eğer kitap mevcut değilse ife girer
            mevcut = true;//iade edildiği için mevcut durumu true olarak değiştirir.
            iadeTarihi = LocalDate.now();//İade tarihini bugünün tarihi olarak ayarlar.
            oduncAlan = null;//ödünç alan kişiyi temizler
            oduncAlmaTarihi = null;//ödünç alma tarihini temizler
            teslimTarihi = null;//teslim tarihini temizler
            System.out.println(isim + " iade edildi.");//kitabın iaede edildiği yazdırılır.
        } else {
            System.out.println(isim + " zaten kütüphanede.");//diğer bloğa girmiyorsa bu blok çalışır.kitap zaten kütüphanededir.
        }
    }

    public void setMevcut(boolean mevcut) {//Kitabın mevcut olup olmadığını ayarlayan bir metot.
        this.mevcut = mevcut;//mevcut duruma atadığımız değeri alır.
    }

    @Override//toString fonk.yok sayar
    public String toString() {//Kitap sınıfının string temsili.
        //Kitap bilgilerini ve eğer ödünç alınmışsa ödünç alma ve iade tarihlerini içeren bir string döner.
        return "İsim: " + isim + ", Yazar: " + yazar + ", ISBN: " + ISBN +
                (oduncAlan != null ? ", Ödünç Alan: " + oduncAlan + ", Ödünç Alma Tarihi:" +
                        " " + oduncAlmaTarihi + ", Teslim Tarihi: " + teslimTarihi : "") +
                (iadeTarihi != null ? ", İade Tarihi: " + iadeTarihi : "");
    }
}
