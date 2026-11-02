<#ftl output_format="HTML">

<style>
    .title {
        font-size: 18px;
        font-weight: bold;
        margin-bottom: 15px;
    }

    .status {
        background: #e6f4ea;
        color: #137333;
        padding: 12px;
        border-radius: 6px;
        font-weight: bold;
    }

    .section {
        margin-top: 15px;
        font-weight: bold;
        color: #526581;
    }

    .content {
        background: #f4f6f9;
        padding: 12px;
        border-radius: 6px;
        margin-top: 5px;
        overflow-x: auto;
    }

    .item {
        padding: 5px 0;
        border-bottom: 1px solid #e5e7eb;
    }
</style>

<div class="title">HTTP RESPONSE</div>

<div class="status">
    Status code: ${data.responseCode!"Unknown"}
</div>

<#if data.url??>
    <div class="content">
        <b>URL:</b> ${data.url}
    </div>
</#if>

<#if data.body??>
    <div class="section">Response Body</div>
    <pre class="content">${data.body}</pre>
</#if>

<#if (data.headers)?has_content>
    <div class="section">Headers</div>
    <div class="content">
        <#list data.headers as name, value>
            <div class="item">
                <b>${name}:</b> ${value!"null"}
            </div>
        </#list>
    </div>
</#if>

<#if (data.cookies)?has_content>
    <div class="section">Cookies</div>
    <div class="content">
        <#list data.cookies as name, value>
            <div class="item">
                <b>${name}:</b> ${value!"null"}
            </div>
        </#list>
    </div>
</#if>