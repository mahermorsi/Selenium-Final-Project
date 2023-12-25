package Logic;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemApiResponse {

    private List<Sale> sales;
    private List<Item> items;
    private Double price;
    private Double priceClub;
    private Double discountClub;
    private Double priceWallet;
    private Double discountWallet;
    private Double discount;
    private int quantity;
    private String logId;
    private int status;
    private Meta meta;

    @JsonCreator
    public ItemApiResponse(
            @JsonProperty("sales") List<Sale> sales,
            @JsonProperty("items") List<Item> items,
            @JsonProperty("price") Double price,
            @JsonProperty("priceClub") Double priceClub,
            @JsonProperty("discountClub") Double discountClub,
            @JsonProperty("priceWallet") Double priceWallet,
            @JsonProperty("discountWallet") Double discountWallet,
            @JsonProperty("discount") Double discount,
            @JsonProperty("quantity") int quantity,
            @JsonProperty("log_id") String logId,
            @JsonProperty("status") int status,
            @JsonProperty("meta") Meta meta) {
        this.sales = sales;
        this.items = items;
        this.price = price;
        this.priceClub = priceClub;
        this.discountClub = discountClub;
        this.priceWallet = priceWallet;
        this.discountWallet = discountWallet;
        this.discount = discount;
        this.quantity = quantity;
        this.logId = logId;
        this.status = status;
        this.meta = meta;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public List<Item> getItems() {
        return items;
    }

    public Double getPrice() {
        return price;
    }

    public Double getPriceClub() {
        return priceClub;
    }

    public Double getDiscountClub() {
        return discountClub;
    }

    public Double getPriceWallet() {
        return priceWallet;
    }

    public Double getDiscountWallet() {
        return discountWallet;
    }

    public Double getDiscount() {
        return discount;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getLogId() {
        return logId;
    }

    public int getStatus() {
        return status;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setPriceClub(Double priceClub) {
        this.priceClub = priceClub;
    }

    public void setDiscountClub(Double discountClub) {
        this.discountClub = discountClub;
    }

    public void setPriceWallet(Double priceWallet) {
        this.priceWallet = priceWallet;
    }

    public void setDiscountWallet(Double discountWallet) {
        this.discountWallet = discountWallet;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    @Override
    public String toString() {
        return "ItemApiResponse{" +
                "sales=" + sales +
                ", items=" + items +
                ", price=" + price +
                ", priceClub=" + priceClub +
                ", discountClub=" + discountClub +
                ", priceWallet=" + priceWallet +
                ", discountWallet=" + discountWallet +
                ", discount=" + discount +
                ", quantity=" + quantity +
                ", logId='" + logId + '\'' +
                ", status=" + status +
                ", meta=" + meta +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Sale {
        private int code;
        private int swKefel;
        private String kCmt;
        private String kAczDis;
        private int active;
        private int cmt;
        private int type;
        private int isWallet;
        private int isPersonal;
        private String name;
        private String kScm;
        private List<Object> days;
        private List<Object> kItems;
        private String from;
        private int id;
        private String to;
        private double scm;
        private int isClub;
        private int countInEveryDivided;

        @JsonCreator
        public Sale(
                @JsonProperty("code") int code,
                @JsonProperty("sw_kefel") int swKefel,
                @JsonProperty("k_cmt") String kCmt,
                @JsonProperty("k_acz_dis") String kAczDis,
                @JsonProperty("active") int active,
                @JsonProperty("cmt") int cmt,
                @JsonProperty("type") int type,
                @JsonProperty("is_wallet") int isWallet,
                @JsonProperty("is_personal") int isPersonal,
                @JsonProperty("name") String name,
                @JsonProperty("k_scm") String kScm,
                @JsonProperty("days") List<Object> days,
                @JsonProperty("k_items") List<Object> kItems,
                @JsonProperty("from") String from,
                @JsonProperty("id") int id,
                @JsonProperty("to") String to,
                @JsonProperty("scm") double scm,
                @JsonProperty("is_club") int isClub,
                @JsonProperty("countInEveryDivided") int countInEveryDivided) {
            this.code = code;
            this.swKefel = swKefel;
            this.kCmt = kCmt;
            this.kAczDis = kAczDis;
            this.active = active;
            this.cmt = cmt;
            this.type = type;
            this.isWallet = isWallet;
            this.isPersonal = isPersonal;
            this.name = name;
            this.kScm = kScm;
            this.days = days;
            this.kItems = kItems;
            this.from = from;
            this.id = id;
            this.to = to;
            this.scm = scm;
            this.isClub = isClub;
            this.countInEveryDivided = countInEveryDivided;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public int getSwKefel() {
            return swKefel;
        }

        public void setSwKefel(int swKefel) {
            this.swKefel = swKefel;
        }

        public String getkCmt() {
            return kCmt;
        }

        public void setkCmt(String kCmt) {
            this.kCmt = kCmt;
        }

        public String getkAczDis() {
            return kAczDis;
        }

        public void setkAczDis(String kAczDis) {
            this.kAczDis = kAczDis;
        }

        public int getActive() {
            return active;
        }

        public void setActive(int active) {
            this.active = active;
        }

        public int getCmt() {
            return cmt;
        }

        public void setCmt(int cmt) {
            this.cmt = cmt;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getIsWallet() {
            return isWallet;
        }

        public void setIsWallet(int isWallet) {
            this.isWallet = isWallet;
        }

        public int getIsPersonal() {
            return isPersonal;
        }

        public void setIsPersonal(int isPersonal) {
            this.isPersonal = isPersonal;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getkScm() {
            return kScm;
        }

        public void setkScm(String kScm) {
            this.kScm = kScm;
        }

        public List<Object> getDays() {
            return days;
        }

        public void setDays(List<Object> days) {
            this.days = days;
        }

        public List<Object> getkItems() {
            return kItems;
        }

        public void setkItems(List<Object> kItems) {
            this.kItems = kItems;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public double getScm() {
            return scm;
        }

        public void setScm(double scm) {
            this.scm = scm;
        }

        public int getIsClub() {
            return isClub;
        }

        public void setIsClub(int isClub) {
            this.isClub = isClub;
        }

        public int getCountInEveryDivided() {
            return countInEveryDivided;
        }

        public void setCountInEveryDivided(int countInEveryDivided) {
            this.countInEveryDivided = countInEveryDivided;
        }

        @Override
        public String toString() {
            return "Sale{" +
                    "code=" + code +
                    ", swKefel=" + swKefel +
                    ", kCmt='" + kCmt + '\'' +
                    ", kAczDis='" + kAczDis + '\'' +
                    ", active=" + active +
                    ", cmt=" + cmt +
                    ", type=" + type +
                    ", isWallet=" + isWallet +
                    ", isPersonal=" + isPersonal +
                    ", name='" + name + '\'' +
                    ", kScm='" + kScm + '\'' +
                    ", days=" + days +
                    ", kItems=" + kItems +
                    ", from='" + from + '\'' +
                    ", id=" + id +
                    ", to='" + to + '\'' +
                    ", scm=" + scm +
                    ", isClub=" + isClub +
                    ", countInEveryDivided=" + countInEveryDivided +
                    '}';
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Item {
        private Object countUsesSale;
        private double formatedSavePrice;
        private double formatedTotalPrice;
        private double formatedSavePriceClub;
        private double formatedSavePriceWallet;
        private double formatedTotalPriceClub;
        private double formatedTotalPriceWallet;
        private double formatedTotalPriceWithoutDiscount;
        private double finalPriceClub;
        private double finalPriceWallet;
        private List<Integer> promotionIdClub;
        private int siteId;
        private int id;
        private String name;
        private double price;
        private int quantity;
        private boolean hasCoupon;
        private boolean isDelivery;
        private boolean isClub;
        private boolean isWallet;
        private Object countUsesSaleWallet;

        @JsonCreator
        public Item(
                @JsonProperty("countUsesSale") Object countUsesSale,
                @JsonProperty("FormatedSavePrice") double formatedSavePrice,
                @JsonProperty("FormatedTotalPrice") double formatedTotalPrice,
                @JsonProperty("FormatedSavePriceClub") double formatedSavePriceClub,
                @JsonProperty("FormatedSavePriceWallet") double formatedSavePriceWallet,
                @JsonProperty("FormatedTotalPriceClub") double formatedTotalPriceClub,
                @JsonProperty("FormatedTotalPriceWallet") double formatedTotalPriceWallet,
                @JsonProperty("FormatedTotalPriceWithoutDiscount") double formatedTotalPriceWithoutDiscount,
                @JsonProperty("finalPriceClub") double finalPriceClub,
                @JsonProperty("finalPriceWallet") double finalPriceWallet,
                @JsonProperty("PromotionIdClub") List<Integer> promotionIdClub,
                @JsonProperty("site_id") int siteId,
                @JsonProperty("id") int id,
                @JsonProperty("name") String name,
                @JsonProperty("price") double price,
                @JsonProperty("quantity") int quantity,
                @JsonProperty("has_coupon") boolean hasCoupon,
                @JsonProperty("is_delivery") boolean isDelivery,
                @JsonProperty("isClub") boolean isClub,
                @JsonProperty("isWallet") boolean isWallet,
                @JsonProperty("countUsesSaleWallet") Object countUsesSaleWallet) {
            this.countUsesSale = countUsesSale;
            this.formatedSavePrice = formatedSavePrice;
            this.formatedTotalPrice = formatedTotalPrice;
            this.formatedSavePriceClub = formatedSavePriceClub;
            this.formatedSavePriceWallet = formatedSavePriceWallet;
            this.formatedTotalPriceClub = formatedTotalPriceClub;
            this.formatedTotalPriceWallet = formatedTotalPriceWallet;
            this.formatedTotalPriceWithoutDiscount = formatedTotalPriceWithoutDiscount;
            this.finalPriceClub = finalPriceClub;
            this.finalPriceWallet = finalPriceWallet;
            this.promotionIdClub = promotionIdClub;
            this.siteId = siteId;
            this.id = id;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
            this.hasCoupon = hasCoupon;
            this.isDelivery = isDelivery;
            this.isClub = isClub;
            this.isWallet = isWallet;
            this.countUsesSaleWallet = countUsesSaleWallet;
        }

        public Object getCountUsesSale() {
            return countUsesSale;
        }

        public void setCountUsesSale(Object countUsesSale) {
            this.countUsesSale = countUsesSale;
        }

        public double getFormatedSavePrice() {
            return formatedSavePrice;
        }

        public void setFormatedSavePrice(double formatedSavePrice) {
            this.formatedSavePrice = formatedSavePrice;
        }

        public double getFormatedTotalPrice() {
            return formatedTotalPrice;
        }

        public void setFormatedTotalPrice(double formatedTotalPrice) {
            this.formatedTotalPrice = formatedTotalPrice;
        }

        public double getFormatedSavePriceClub() {
            return formatedSavePriceClub;
        }

        public void setFormatedSavePriceClub(double formatedSavePriceClub) {
            this.formatedSavePriceClub = formatedSavePriceClub;
        }

        public double getFormatedSavePriceWallet() {
            return formatedSavePriceWallet;
        }

        public void setFormatedSavePriceWallet(double formatedSavePriceWallet) {
            this.formatedSavePriceWallet = formatedSavePriceWallet;
        }

        public double getFormatedTotalPriceClub() {
            return formatedTotalPriceClub;
        }

        public void setFormatedTotalPriceClub(double formatedTotalPriceClub) {
            this.formatedTotalPriceClub = formatedTotalPriceClub;
        }

        public double getFormatedTotalPriceWallet() {
            return formatedTotalPriceWallet;
        }

        public void setFormatedTotalPriceWallet(double formatedTotalPriceWallet) {
            this.formatedTotalPriceWallet = formatedTotalPriceWallet;
        }

        public double getFormatedTotalPriceWithoutDiscount() {
            return formatedTotalPriceWithoutDiscount;
        }

        public void setFormatedTotalPriceWithoutDiscount(double formatedTotalPriceWithoutDiscount) {
            this.formatedTotalPriceWithoutDiscount = formatedTotalPriceWithoutDiscount;
        }

        public double getFinalPriceClub() {
            return finalPriceClub;
        }

        public void setFinalPriceClub(double finalPriceClub) {
            this.finalPriceClub = finalPriceClub;
        }

        public double getFinalPriceWallet() {
            return finalPriceWallet;
        }

        public void setFinalPriceWallet(double finalPriceWallet) {
            this.finalPriceWallet = finalPriceWallet;
        }

        public List<Integer> getPromotionIdClub() {
            return promotionIdClub;
        }

        public void setPromotionIdClub(List<Integer> promotionIdClub) {
            this.promotionIdClub = promotionIdClub;
        }

        public int getSiteId() {
            return siteId;
        }

        public void setSiteId(int siteId) {
            this.siteId = siteId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public boolean isHasCoupon() {
            return hasCoupon;
        }

        public void setHasCoupon(boolean hasCoupon) {
            this.hasCoupon = hasCoupon;
        }

        public boolean isDelivery() {
            return isDelivery;
        }

        public void setDelivery(boolean delivery) {
            isDelivery = delivery;
        }

        public boolean isClub() {
            return isClub;
        }

        public void setClub(boolean club) {
            isClub = club;
        }

        public boolean isWallet() {
            return isWallet;
        }

        public void setWallet(boolean wallet) {
            isWallet = wallet;
        }

        public Object getCountUsesSaleWallet() {
            return countUsesSaleWallet;
        }

        public void setCountUsesSaleWallet(Object countUsesSaleWallet) {
            this.countUsesSaleWallet = countUsesSaleWallet;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "countUsesSale=" + countUsesSale +
                    ", formatedSavePrice=" + formatedSavePrice +
                    ", formatedTotalPrice=" + formatedTotalPrice +
                    ", formatedSavePriceClub=" + formatedSavePriceClub +
                    ", formatedSavePriceWallet=" + formatedSavePriceWallet +
                    ", formatedTotalPriceClub=" + formatedTotalPriceClub +
                    ", formatedTotalPriceWallet=" + formatedTotalPriceWallet +
                    ", formatedTotalPriceWithoutDiscount=" + formatedTotalPriceWithoutDiscount +
                    ", finalPriceClub=" + finalPriceClub +
                    ", finalPriceWallet=" + finalPriceWallet +
                    ", promotionIdClub=" + promotionIdClub +
                    ", siteId=" + siteId +
                    ", id=" + id +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    ", quantity=" + quantity +
                    ", hasCoupon=" + hasCoupon +
                    ", isDelivery=" + isDelivery +
                    ", isClub=" + isClub +
                    ", isWallet=" + isWallet +
                    ", countUsesSaleWallet=" + countUsesSaleWallet +
                    '}';
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Meta {
        private int ct;
        private double ms;
        private int cs;

        @JsonCreator
        public Meta(
                @JsonProperty("ct") int ct,
                @JsonProperty("ms") double ms,
                @JsonProperty("cs") int cs) {
            this.ct = ct;
            this.ms = ms;
            this.cs = cs;
        }

        public int getCt() {
            return ct;
        }

        public double getMs() {
            return ms;
        }

        public int getCs() {
            return cs;
        }

        @Override
        public String toString() {
            return "Meta{" +
                    "ct=" + ct +
                    ", ms=" + ms +
                    ", cs=" + cs +
                    '}';
        }
    }
}
