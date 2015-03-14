/**
 * This class is generated by jOOQ
 */
package je.backit.jooq.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.5.3"
	},
	comments = "This class is generated by jOOQ"
)
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CampaignTag extends org.jooq.impl.TableImpl<je.backit.jooq.tables.records.CampaignTagRecord> {

	private static final long serialVersionUID = -268327939;

	/**
	 * The reference instance of <code>public.campaign_tag</code>
	 */
	public static final je.backit.jooq.tables.CampaignTag CAMPAIGN_TAG = new je.backit.jooq.tables.CampaignTag();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<je.backit.jooq.tables.records.CampaignTagRecord> getRecordType() {
		return je.backit.jooq.tables.records.CampaignTagRecord.class;
	}

	/**
	 * The column <code>public.campaign_tag.campaign_id</code>.
	 */
	public final org.jooq.TableField<je.backit.jooq.tables.records.CampaignTagRecord, java.lang.Integer> CAMPAIGN_ID = createField("campaign_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>public.campaign_tag.category_id</code>.
	 */
	public final org.jooq.TableField<je.backit.jooq.tables.records.CampaignTagRecord, java.lang.Integer> CATEGORY_ID = createField("category_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * Create a <code>public.campaign_tag</code> table reference
	 */
	public CampaignTag() {
		this("campaign_tag", null);
	}

	/**
	 * Create an aliased <code>public.campaign_tag</code> table reference
	 */
	public CampaignTag(java.lang.String alias) {
		this(alias, je.backit.jooq.tables.CampaignTag.CAMPAIGN_TAG);
	}

	private CampaignTag(java.lang.String alias, org.jooq.Table<je.backit.jooq.tables.records.CampaignTagRecord> aliased) {
		this(alias, aliased, null);
	}

	private CampaignTag(java.lang.String alias, org.jooq.Table<je.backit.jooq.tables.records.CampaignTagRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, je.backit.jooq.Public.PUBLIC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<je.backit.jooq.tables.records.CampaignTagRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<je.backit.jooq.tables.records.CampaignTagRecord, ?>>asList(je.backit.jooq.Keys.CAMPAIGN_TAG__CAMPAIGN_TAG_CAMPAIGN_ID_FKEY, je.backit.jooq.Keys.CAMPAIGN_TAG__CAMPAIGN_TAG_CATEGORY_ID_FKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public je.backit.jooq.tables.CampaignTag as(java.lang.String alias) {
		return new je.backit.jooq.tables.CampaignTag(alias, this);
	}

	/**
	 * Rename this table
	 */
	public je.backit.jooq.tables.CampaignTag rename(java.lang.String name) {
		return new je.backit.jooq.tables.CampaignTag(name, null);
	}
}
