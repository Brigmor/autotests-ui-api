<#ftl output_format="HTML">

<style>
    .title {
        font-size: 18px;
        font-weight: bold;
        margin-bottom: 15px;
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

<div class="title">HTTP REQUEST</div>

<div class="content">
    <b>Method:</b> ${data.method!"GET"}<br>
    <b>URL:</b> ${data.url!"Unknown"}
</div>

<#if data.body??>
    <div class="section">Request Body</div>
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

<#if data.curl??>
    <div class="section">cURL</div>
    <pre class="content">${data.curl}</pre>
</#if>

<#if (data.formParams)?has_content>
    <div class="section">Form Parameters</div>
    <div class="content">
        <#list data.formParams as name, value>
            <div class="item">${name}: ${value!"null"}</div>
        </#list>
    </div>
</#if>