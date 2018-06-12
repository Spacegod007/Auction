
package service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _NewBid_QNAME = new QName("http://service/", "newBid");
    private final static QName _Item_QNAME = new QName("http://service/", "item");
    private final static QName _RevokeItem_QNAME = new QName("http://service/", "revokeItem");
    private final static QName _FindItemByDescriptionResponse_QNAME = new QName("http://service/", "findItemByDescriptionResponse");
    private final static QName _OfferItem_QNAME = new QName("http://service/", "offerItem");
    private final static QName _FontysTime_QNAME = new QName("http://service/", "fontysTime");
    private final static QName _RevokeItemResponse_QNAME = new QName("http://service/", "revokeItemResponse");
    private final static QName _NewBidResponse_QNAME = new QName("http://service/", "newBidResponse");
    private final static QName _GetItem_QNAME = new QName("http://service/", "getItem");
    private final static QName _OfferFurnitureResponse_QNAME = new QName("http://service/", "offerFurnitureResponse");
    private final static QName _OfferPainting_QNAME = new QName("http://service/", "offerPainting");
    private final static QName _GetItemResponse_QNAME = new QName("http://service/", "getItemResponse");
    private final static QName _Money_QNAME = new QName("http://service/", "money");
    private final static QName _OfferPaintingResponse_QNAME = new QName("http://service/", "offerPaintingResponse");
    private final static QName _FindItemByDescription_QNAME = new QName("http://service/", "findItemByDescription");
    private final static QName _OfferItemResponse_QNAME = new QName("http://service/", "offerItemResponse");
    private final static QName _User_QNAME = new QName("http://service/", "user");
    private final static QName _Bid_QNAME = new QName("http://service/", "bid");
    private final static QName _Category_QNAME = new QName("http://service/", "category");
    private final static QName _OfferFurniture_QNAME = new QName("http://service/", "offerFurniture");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindItemByDescriptionResponse }
     * 
     */
    public FindItemByDescriptionResponse createFindItemByDescriptionResponse() {
        return new FindItemByDescriptionResponse();
    }

    /**
     * Create an instance of {@link Item }
     * 
     */
    public Item createItem() {
        return new Item();
    }

    /**
     * Create an instance of {@link RevokeItem }
     * 
     */
    public RevokeItem createRevokeItem() {
        return new RevokeItem();
    }

    /**
     * Create an instance of {@link NewBid }
     * 
     */
    public NewBid createNewBid() {
        return new NewBid();
    }

    /**
     * Create an instance of {@link OfferFurnitureResponse }
     * 
     */
    public OfferFurnitureResponse createOfferFurnitureResponse() {
        return new OfferFurnitureResponse();
    }

    /**
     * Create an instance of {@link GetItem }
     * 
     */
    public GetItem createGetItem() {
        return new GetItem();
    }

    /**
     * Create an instance of {@link NewBidResponse }
     * 
     */
    public NewBidResponse createNewBidResponse() {
        return new NewBidResponse();
    }

    /**
     * Create an instance of {@link FontysTime }
     * 
     */
    public FontysTime createFontysTime() {
        return new FontysTime();
    }

    /**
     * Create an instance of {@link RevokeItemResponse }
     * 
     */
    public RevokeItemResponse createRevokeItemResponse() {
        return new RevokeItemResponse();
    }

    /**
     * Create an instance of {@link OfferItem }
     * 
     */
    public OfferItem createOfferItem() {
        return new OfferItem();
    }

    /**
     * Create an instance of {@link FindItemByDescription }
     * 
     */
    public FindItemByDescription createFindItemByDescription() {
        return new FindItemByDescription();
    }

    /**
     * Create an instance of {@link OfferItemResponse }
     * 
     */
    public OfferItemResponse createOfferItemResponse() {
        return new OfferItemResponse();
    }

    /**
     * Create an instance of {@link GetItemResponse }
     * 
     */
    public GetItemResponse createGetItemResponse() {
        return new GetItemResponse();
    }

    /**
     * Create an instance of {@link Money }
     * 
     */
    public Money createMoney() {
        return new Money();
    }

    /**
     * Create an instance of {@link OfferPaintingResponse }
     * 
     */
    public OfferPaintingResponse createOfferPaintingResponse() {
        return new OfferPaintingResponse();
    }

    /**
     * Create an instance of {@link OfferPainting }
     * 
     */
    public OfferPainting createOfferPainting() {
        return new OfferPainting();
    }

    /**
     * Create an instance of {@link OfferFurniture }
     * 
     */
    public OfferFurniture createOfferFurniture() {
        return new OfferFurniture();
    }

    /**
     * Create an instance of {@link Bid }
     * 
     */
    public Bid createBid() {
        return new Bid();
    }

    /**
     * Create an instance of {@link Category }
     * 
     */
    public Category createCategory() {
        return new Category();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NewBid }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "newBid")
    public JAXBElement<NewBid> createNewBid(NewBid value) {
        return new JAXBElement<NewBid>(_NewBid_QNAME, NewBid.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Item }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "item")
    public JAXBElement<Item> createItem(Item value) {
        return new JAXBElement<Item>(_Item_QNAME, Item.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RevokeItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "revokeItem")
    public JAXBElement<RevokeItem> createRevokeItem(RevokeItem value) {
        return new JAXBElement<RevokeItem>(_RevokeItem_QNAME, RevokeItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindItemByDescriptionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "findItemByDescriptionResponse")
    public JAXBElement<FindItemByDescriptionResponse> createFindItemByDescriptionResponse(FindItemByDescriptionResponse value) {
        return new JAXBElement<FindItemByDescriptionResponse>(_FindItemByDescriptionResponse_QNAME, FindItemByDescriptionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OfferItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "offerItem")
    public JAXBElement<OfferItem> createOfferItem(OfferItem value) {
        return new JAXBElement<OfferItem>(_OfferItem_QNAME, OfferItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FontysTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "fontysTime")
    public JAXBElement<FontysTime> createFontysTime(FontysTime value) {
        return new JAXBElement<FontysTime>(_FontysTime_QNAME, FontysTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RevokeItemResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "revokeItemResponse")
    public JAXBElement<RevokeItemResponse> createRevokeItemResponse(RevokeItemResponse value) {
        return new JAXBElement<RevokeItemResponse>(_RevokeItemResponse_QNAME, RevokeItemResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NewBidResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "newBidResponse")
    public JAXBElement<NewBidResponse> createNewBidResponse(NewBidResponse value) {
        return new JAXBElement<NewBidResponse>(_NewBidResponse_QNAME, NewBidResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetItem }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getItem")
    public JAXBElement<GetItem> createGetItem(GetItem value) {
        return new JAXBElement<GetItem>(_GetItem_QNAME, GetItem.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OfferFurnitureResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "offerFurnitureResponse")
    public JAXBElement<OfferFurnitureResponse> createOfferFurnitureResponse(OfferFurnitureResponse value) {
        return new JAXBElement<OfferFurnitureResponse>(_OfferFurnitureResponse_QNAME, OfferFurnitureResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OfferPainting }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "offerPainting")
    public JAXBElement<OfferPainting> createOfferPainting(OfferPainting value) {
        return new JAXBElement<OfferPainting>(_OfferPainting_QNAME, OfferPainting.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetItemResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "getItemResponse")
    public JAXBElement<GetItemResponse> createGetItemResponse(GetItemResponse value) {
        return new JAXBElement<GetItemResponse>(_GetItemResponse_QNAME, GetItemResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Money }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "money")
    public JAXBElement<Money> createMoney(Money value) {
        return new JAXBElement<Money>(_Money_QNAME, Money.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OfferPaintingResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "offerPaintingResponse")
    public JAXBElement<OfferPaintingResponse> createOfferPaintingResponse(OfferPaintingResponse value) {
        return new JAXBElement<OfferPaintingResponse>(_OfferPaintingResponse_QNAME, OfferPaintingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindItemByDescription }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "findItemByDescription")
    public JAXBElement<FindItemByDescription> createFindItemByDescription(FindItemByDescription value) {
        return new JAXBElement<FindItemByDescription>(_FindItemByDescription_QNAME, FindItemByDescription.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OfferItemResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "offerItemResponse")
    public JAXBElement<OfferItemResponse> createOfferItemResponse(OfferItemResponse value) {
        return new JAXBElement<OfferItemResponse>(_OfferItemResponse_QNAME, OfferItemResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link User }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "user")
    public JAXBElement<User> createUser(User value) {
        return new JAXBElement<User>(_User_QNAME, User.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Bid }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "bid")
    public JAXBElement<Bid> createBid(Bid value) {
        return new JAXBElement<Bid>(_Bid_QNAME, Bid.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Category }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "category")
    public JAXBElement<Category> createCategory(Category value) {
        return new JAXBElement<Category>(_Category_QNAME, Category.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OfferFurniture }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "offerFurniture")
    public JAXBElement<OfferFurniture> createOfferFurniture(OfferFurniture value) {
        return new JAXBElement<OfferFurniture>(_OfferFurniture_QNAME, OfferFurniture.class, null, value);
    }

}
